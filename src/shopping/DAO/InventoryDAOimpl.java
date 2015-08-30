package shopping.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import shopping.Business.MySQLconn;
import shopping.Class.Inventory;

public class InventoryDAOimpl implements InventoryDAO{

	private int IdCheck() {		
		String sql = "SELECT MAX(StockNumber) FROM Inventory";
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
	public int add(Inventory i) {
		String sql = "INSERT INTO Inventory VALUES(null,?,?,?,?,?)";
		try (Connection conn = MySQLconn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, i.getProductID());
			pstmt.setFloat(2, i.getCost());
			pstmt.setInt(3, i.getUnitsInStock());
			pstmt.setInt(4, i.getUnitsOnOrder());
			pstmt.setInt(5, i.getSaftyStock());

			pstmt.executeUpdate();
			System.out.println("Inventory新增成功");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return IdCheck();
		
	}

	@Override
	public void update(Inventory i) {
		String sql = "UPDATE Inventory SET ProductID = ?, "
				+ "Cost = ?, "
				+ "UnitsInStock = ?, "
				+ "UnitsOnOrder = ?, "
				+ "SaftyStock = ? WHERE StockNumber = ?";
			try (Connection conn = MySQLconn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setInt(1, i.getProductID());
				pstmt.setFloat(2, i.getCost());
				pstmt.setInt(3, i.getUnitsInStock());
				pstmt.setInt(4, i.getUnitsOnOrder());
				pstmt.setInt(5, i.getSaftyStock());
				pstmt.setInt(6, i.getStockNumber());
			
				pstmt.executeUpdate();
				System.out.println("Inventory更新成功");
			} catch (SQLException e) {
			System.out.println(e.getMessage());
			}
		
	}

	@Override
	public void delete(Inventory i) {
		String sql = "DELETE FROM Inventory WHERE StockNumber = ?";
		try (Connection conn = MySQLconn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, i.getStockNumber());
			int count = pstmt.executeUpdate();
			System.out.println(count+"row has been affected");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public Inventory searchbyID(int StockNumber) {
		String sql = "SELECT * FROM Inventory WHERE StockNumber = ?";
		Inventory i = new Inventory();
		try (Connection conn = MySQLconn.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setInt(1, StockNumber);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
			i.setStockNumber(rs.getInt(1));
			i.setProductID(rs.getInt(2));
			i.setCost(rs.getFloat(3));
			i.setUnitsInStock(rs.getInt(4));
			i.setUnitsOnOrder(rs.getInt(5));
			i.setSaftyStock(rs.getInt(6));
			
			return i;
			
			}else{
			return null;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return i;
	}

	@Override
	public ArrayList<Inventory> showAll() {
		String sql = "SELECT * FROM Inventory ORDER BY StockNumber";
		ArrayList<Inventory> al = new ArrayList<>();
		try (Connection conn = MySQLconn.getConnection(); 
				Statement stmt = conn.createStatement(); 
				ResultSet rs = stmt.executeQuery(sql)) {
			
			while(rs.next()){
				al.add(new Inventory(rs.getInt(1),
									rs.getInt(2),
									rs.getFloat(3),
									rs.getInt(4),
									rs.getInt(5),
									rs.getInt(6)));
				}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return al;
	}

    @Override
    public ArrayList<Inventory> getRange(int offset, int count) {
        String sql = "SELECT * FROM Inventory ORDER BY ProductID LIMIT = ?,?";
		ArrayList<Inventory> al = new ArrayList<>();
		try (Connection conn = MySQLconn.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setInt(1,(offset-1));
				pstmt.setInt(2,count);
				ResultSet rs = pstmt.executeQuery();
				
			while(rs.next()){
				al.add(new Inventory(rs.getInt(1),
									rs.getInt(2),
									rs.getFloat(3),
									rs.getInt(4),
									rs.getInt(5),
									rs.getInt(6)));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return al;
    }

    @Override
    public int getSize() {
        String sql = "SELECT count(*) FROM Inventory";
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
