package shopping.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import shopping.Business.MySQLconn;
import shopping.Class.OrderDetail;

public class OrderDetailDAOimpl implements OrderDetailDAO{
	
	@Override
	public int add(OrderDetail od) {
                int ID = 0;
		String sql = "INSERT INTO OrderDetails VALUES(null,?,?,?,?,?)";
		try (Connection conn = MySQLconn.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {

			pstmt.setInt(1, od.getOrderID());
			pstmt.setInt(2, od.getProductID());
			pstmt.setInt(3, od.getGiftSetID());
			if(od.getProductID()==null){
                        pstmt.setNull(2,java.sql.Types.INTEGER);				
			}else{
			pstmt.setInt(2, od.getProductID());}
			if(od.getGiftSetID()==null){
                        pstmt.setNull(3,java.sql.Types.INTEGER);				
			}else{
			pstmt.setInt(3, od.getGiftSetID());}
			pstmt.setFloat(4, od.getSalesPrice());
			pstmt.setInt(5, od.getQuantity());

			pstmt.executeUpdate();
			System.out.println("OrderDetail新增成功");
                        ResultSet rs = pstmt.getGeneratedKeys();
                        rs.next();
                        ID = rs.getInt(1);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return ID;
		
	}

	@Override
	public void update(OrderDetail od) {
		String sql = "UPDATE OrderDetails SET OrderID = ?, "
				+ "ProductID = ?, "
				+ "GiftSetID = ?, "
				+ "SalesPrice = ?, "
				+ "Quantity = ? WHERE ID = ?";
		
			try (Connection conn = MySQLconn.getConnection(); 
					PreparedStatement pstmt = conn.prepareStatement(sql)) {
				
				pstmt.setInt(1, od.getOrderID());
				pstmt.setInt(2, od.getProductID());
				pstmt.setInt(3, od.getGiftSetID());
				pstmt.setFloat(4, od.getSalesPrice());
				pstmt.setInt(5, od.getQuantity());
				pstmt.setInt(6, od.getID());
				
				pstmt.executeUpdate();
				System.out.println("OrderDetail更新成功");
			} catch (SQLException e) {
			System.out.println(e.getMessage());
			}
		
	}

	@Override
	public void delete(OrderDetail od) {
		String sql = "DELETE FROM OrderDetails WHERE ID = ?";
		try (Connection conn = MySQLconn.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setInt(1, od.getID());
			int count = pstmt.executeUpdate();
			System.out.println(count+"row has been affected");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public OrderDetail searchbyID(int ID) {
		String sql = "SELECT * FROM OrderDetails WHERE ID = ?";
		OrderDetail od = new OrderDetail();
		try (Connection conn = MySQLconn.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setInt(1, ID);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
			od.setID(rs.getInt(1));
			od.setOrderID(rs.getInt(2));
			od.setProductID(rs.getInt(3));
			od.setGiftSetID(rs.getInt(4));
			od.setSalesPrice(rs.getFloat(5));
			od.setQuantity(rs.getInt(6));
			
			return od;
			
			}else{
			return null;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return od;
	}

	@Override
	public ArrayList<OrderDetail> showAll() {
		String sql = "SELECT * FROM OrderDetails ORDER BY ID";
		ArrayList<OrderDetail> al = new ArrayList<>();
		try (Connection conn = MySQLconn.getConnection(); 
				Statement stmt = conn.createStatement(); 
				ResultSet rs = stmt.executeQuery(sql)) {
			
			while(rs.next()){
				al.add(new OrderDetail(rs.getInt(1),
									rs.getInt(2),
									rs.getInt(3),
									rs.getInt(4),
									rs.getFloat(5),
									rs.getInt(6)));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return al;
	}
	
}
