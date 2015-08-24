package shopping.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import shopping.Business.MySQLconn;
import shopping.Class.Order;

public class OrderDAOimpl implements OrderDAO{

	private int IdCheck() {		
		String sql = "SELECT MAX(OrderID) FROM Orders";
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
	public int add(Order o) {
		String sql = "INSERT INTO Orders VALUES(null,?,?,?,?,?)";
		try (Connection conn = MySQLconn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, o.getCustomerID());
			pstmt.setString(2, o.getOrderDate());
			pstmt.setString(3, o.getShipDate());
			pstmt.setInt(4, o.getDiscountID());
			pstmt.setByte(5, o.getCanceled());

			pstmt.executeUpdate();
			System.out.println("Order新增成功");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return IdCheck();
		
	}

	@Override
	public void update(Order o) {
		String sql = "UPDATE Orders SET CustomerID = ?, "
				+ "OrderDate = ?, "
				+ "ShipDate = ?, "
				+ "DiscountID = ?, "
				+ "Canceled = ? WHERE OrderID = ?";
			try (Connection conn = MySQLconn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setInt(1, o.getCustomerID());
				pstmt.setString(2, o.getOrderDate());
				pstmt.setString(3, o.getShipDate());
				pstmt.setInt(4, o.getDiscountID());
				pstmt.setByte(5, o.getCanceled());
				pstmt.setInt(6, o.getOrderID());
			
				pstmt.executeUpdate();
				System.out.println("Order更新成功");
			} catch (SQLException e) {
			System.out.println(e.getMessage());
			}
		
	}

	@Override
	public void delete(Order o) {
		String sql = "DELETE FROM Orders WHERE OrderID = ?";
		try (Connection conn = MySQLconn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, o.getOrderID());
			int count = pstmt.executeUpdate();
			System.out.println(count+"row has been affected");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public Order searchbyID(int OrderID) {
		String sql = "SELECT * FROM Orders WHERE OrderID = ?";
		Order o = new Order();
		try (Connection conn = MySQLconn.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setInt(1, OrderID);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				o.setOrderID(rs.getInt(1));
				o.setCustomerID(rs.getInt(2));
				o.setOrderDate(rs.getString(3));
				o.setShipDate(rs.getString(4));
				o.setDiscountID(rs.getInt(5));
				o.setCanceled(rs.getByte(6));
			
			return o;
			
			}else{
			return null;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return o;
	}

	@Override
	public ArrayList<Order> showAll() {
		String sql = "SELECT * FROM Orders ORDER BY OrderID";
		ArrayList<Order> al = new ArrayList<>();
		try (Connection conn = MySQLconn.getConnection(); 
				Statement stmt = conn.createStatement(); 
				ResultSet rs = stmt.executeQuery(sql)) {
			
			while(rs.next()){
				al.add(new Order(rs.getInt(1),
									rs.getInt(2),
									rs.getString(3),
									rs.getString(4),
									rs.getInt(5),
									rs.getByte(6)));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return al;
	}

}
