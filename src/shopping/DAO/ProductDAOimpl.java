package shopping.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import shopping.Business.MySQLconn;
import shopping.Class.Product;

public class ProductDAOimpl implements ProductDAO{

	private int IdCheck() {		
		String sql = "SELECT MAX(ProductID) FROM Products";
		int ID = 0;
		try(Connection conn = MySQLconn.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
			
			rs.next();
			ID = rs.getInt(1);
				
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return ID;
	}
	
	@Override
	public int add(Product p) {
		String sql = "INSERT INTO Products VALUES(null,?,?,?,?,?,?,?,?)";
		try (Connection conn = MySQLconn.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, p.getBarcode());
			pstmt.setInt(2, p.getCategoryID());
			pstmt.setString(3, p.getProductName());
			pstmt.setString(4, p.getProductUnit());
			pstmt.setString(5, p.getCapacity());
			pstmt.setFloat(6, p.getUnitPrice());
			pstmt.setByte(7, p.getDiscontinued());
			pstmt.setString(8, p.getDescription());

			pstmt.executeUpdate();
			System.out.println("Product新增成功");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return IdCheck();
		
	}

	@Override
	public void update(Product p) {
		String sql = "UPDATE Products SET Barcode = ?, "
				+ "CategoryID = ?, "
				+ "ProductName = ?, "
				+ "ProductUnit = ?, "
				+ "Capacity = ?, "
				+ "UnitPrice = ?, "
				+ "Discontinued = ?, "
				+ "Description = ? WHERE ProductID = ?";
			try (Connection conn = MySQLconn.getConnection(); 
					PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, p.getBarcode());
				pstmt.setInt(2, p.getCategoryID());
				pstmt.setString(3, p.getProductName());
				pstmt.setString(4, p.getProductUnit());
				pstmt.setString(5, p.getCapacity());
				pstmt.setFloat(6, p.getUnitPrice());
				pstmt.setByte(7, p.getDiscontinued());
				pstmt.setString(8, p.getDescription());
				pstmt.setInt(9, p.getProductID());

				pstmt.executeUpdate();
				System.out.println("Product更新成功");
				} catch (SQLException e) {
				System.out.println(e.getMessage());
				}
		
	}

	@Override
	public void delete(Product p) {
		String sql = "DELETE FROM Product WHERE ProductID = ?";
		try (Connection conn = MySQLconn.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, p.getProductID());
			int count = pstmt.executeUpdate();
			System.out.println(count+" row has been affected");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public Product searchbyID(Integer ProductID) {
		String sql = "SELECT * FROM Products WHERE ProductID = ?";
		Product p = new Product();
		try (Connection conn = MySQLconn.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setInt(1, ProductID);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
			p.setProductID(rs.getInt(1));
			p.setBarcode(rs.getString(2));
			p.setCategoryID(rs.getInt(3));
			p.setProductName(rs.getString(4));
			p.setProductUnit(rs.getString(5));
			p.setCapacity(rs.getString(6));
			p.setUnitPrice(rs.getFloat(7));
			p.setDiscontinued(rs.getByte(8));
			p.setDescription(rs.getString(9));
			
			return p;
			
			}else{
			return null;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return p;
	}

	@Override
	public ArrayList<Product> showAll() {
		String sql = "SELECT * FROM Products ORDER BY ProductID";
		ArrayList<Product> al = new ArrayList<>();
		try (Connection conn = MySQLconn.getConnection(); 
				Statement stmt = conn.createStatement(); 
				ResultSet rs = stmt.executeQuery(sql)) {
			
			while(rs.next()){
				al.add(new Product(rs.getInt(1),
									rs.getString(2),
									rs.getInt(3),
									rs.getString(4),
									rs.getString(5),
									rs.getString(6),
									rs.getFloat(7),
									rs.getByte(8),
									rs.getString(9)));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return al;
	}

	@Override
	public ArrayList<Product> gerRange(int offset, int count) {
		String sql = "SELECT * FROM Products ORDER BY ProductID LIMIT ?,?";
		ArrayList<Product> al = new ArrayList<>();
		try (Connection conn = MySQLconn.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setInt(1,(offset-1));
				pstmt.setInt(2,count);
				ResultSet rs = pstmt.executeQuery();
				
			while(rs.next()){
				al.add(new Product(rs.getInt(1),
									rs.getString(2),
									rs.getInt(3),
									rs.getString(4),
									rs.getString(5),
									rs.getString(6),
									rs.getFloat(7),
									rs.getByte(8),
									rs.getString(9)));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return al;
	}

	@Override
	public int getSize() {
			String sql = "SELECT count(*) FROM Products";
			try (Connection conn = MySQLconn.getConnection(); 
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql)) {
				rs.next();
				return rs.getInt(1);
				
					
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return -1;
	}
	

}
