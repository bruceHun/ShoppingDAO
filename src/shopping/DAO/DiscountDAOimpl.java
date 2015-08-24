package shopping.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import shopping.Business.MySQLconn;
import shopping.Class.Discount;

public class DiscountDAOimpl implements DiscountDAO{

	private int IdCheck() {		
		String sql = "SELECT MAX(DiscountID) FROM Discounts";
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
	public int add(Discount d) {
		String sql = "INSERT INTO Discounts VALUES(null,?)";
		try (Connection conn = MySQLconn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

				pstmt.setFloat(1, d.getDiscount());
				

				pstmt.executeUpdate();
				System.out.println("Discount新增成功");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return IdCheck();
		
	}

	@Override
	public void update(Discount d) {
		String sql = "UPDATE Discounts SET Discount = ? WHERE DiscountID = ?";
			try (Connection conn = MySQLconn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setFloat(1, d.getDiscount());
			pstmt.setInt(2, d.getDiscountID());
			
			pstmt.executeUpdate();
			System.out.println("Discount更新成功");
			} catch (SQLException e) {
			System.out.println(e.getMessage());
			}
		
	}

	@Override
	public void delete(Discount d) {
		String sql = "DELETE FROM Discounts WHERE DiscountID = ?";
		try (Connection conn = MySQLconn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, d.getDiscountID());
			int count = pstmt.executeUpdate();
			System.out.println(count+"row has been affected");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public Discount searchbyID(int DiscountID) {
		String sql = "SELECT * FROM Discounts WHERE DiscountID = ?";
		Discount d = new Discount();
		try (Connection conn = MySQLconn.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setInt(1, DiscountID);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
			d.setDiscountID(rs.getInt(1));
			d.setDiscount(rs.getFloat(2));
			
			return d;
			
			}else{
			return null;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return d;
	}

	@Override
	public ArrayList<Discount> showAll() {
		String sql = "SELECT * FROM Discounts ORDER BY DiscountID";
		ArrayList<Discount> al = new ArrayList<>();
		try (Connection conn = MySQLconn.getConnection(); 
				Statement stmt = conn.createStatement(); 
				ResultSet rs = stmt.executeQuery(sql)) {
			
			while(rs.next()){
				al.add(new Discount(rs.getInt(1),
									rs.getFloat(2)));
				}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return al;
	}

}
