package shopping.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import shopping.Business.MySQLconn;
import shopping.Class.ProductCategory;

public class ProductCategoryDAOimpl implements ProductCategoryDAO{

	private int IdCheck() {		
		String sql = "SELECT MAX(CategoryID) FROM ProductCategory";
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
	public int add(ProductCategory pc) {
		String sql = "INSERT INTO ProductCategory VALUES(null,?)";
		try (Connection conn = MySQLconn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

				pstmt.setString(1, pc.getCategoryName());

				pstmt.executeUpdate();
				System.out.println("ProductCategory新增成功");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return IdCheck();
		
	}

	@Override
	public void update(ProductCategory pc) {
		String sql = "UPDATE ProductCategory SET CategoryName = ? WHERE CategoryID = ?";
			try (Connection conn = MySQLconn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, pc.getCategoryName());
			pstmt.setInt(2, pc.getCategoryID());
			
			pstmt.executeUpdate();
			System.out.println("ProductCategory更新成功");
			} catch (SQLException e) {
			System.out.println(e.getMessage());
			}
		
	}

	@Override
	public void delete(ProductCategory pc) {
		String sql = "DELETE FROM ProductCategory WHERE CategoryID = ?";
		try (Connection conn = MySQLconn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, pc.getCategoryID());
			int count = pstmt.executeUpdate();
			System.out.println(count+"row has been affected");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public ProductCategory searchbyID(int CategoryID) {
		String sql = "SELECT * FROM ProductCategory WHERE CategoryID = ?";
		ProductCategory pc = new ProductCategory();
		try (Connection conn = MySQLconn.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setInt(1, CategoryID);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
			pc.setCategoryID(rs.getInt(1));
			pc.setCategoryName(rs.getString(2));
			
			return pc;
			
			}else{
			return null;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return pc;
	}

	@Override
	public ArrayList<ProductCategory> showAll() {
		String sql = "SELECT * FROM ProductCategory ORDER BY CategoryID";
		ArrayList<ProductCategory> al = new ArrayList<>();
		try (Connection conn = MySQLconn.getConnection(); 
				Statement stmt = conn.createStatement(); 
				ResultSet rs = stmt.executeQuery(sql)) {
			
			while(rs.next()){
				al.add(new ProductCategory(rs.getInt(1),
									rs.getString(2)));
				}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return al;
	}

}
