package shopping.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import shopping.Business.MySQLconn;
import shopping.Class.Order;
import shopping.Class.OrderDetail;

public class OrderDAOimpl implements OrderDAO{
	
	@Override
	public Integer add(Order o) {
                int OrderID = 0;
		String sql1 = "INSERT INTO Orders VALUES(null,?,?,?,?,?,1)";
                String sql2 = "INSERT INTO OrderDetails VALUES(null,?,?,?,?,?,1)";
		try (Connection conn = MySQLconn.getConnection(); 
                        PreparedStatement pstmt1 = conn.prepareStatement(sql1,Statement.RETURN_GENERATED_KEYS);
                        PreparedStatement pstmt2 = conn.prepareStatement(sql2)) {
                        
                        conn.setAutoCommit(false);
                        
			pstmt1.setInt(1, o.getCustomerID());
			pstmt1.setString(2, o.getOrderDate());
			pstmt1.setString(3, o.getShipDate());
			pstmt1.setInt(4, o.getDiscountID());
			pstmt1.setByte(5, o.getCanceled());

			pstmt1.executeUpdate();
			System.out.println("Order新增成功");
                        ResultSet rs = pstmt1.getGeneratedKeys();
                        rs.next();
                        OrderID = rs.getInt(1);
                        
                        
                        for(OrderDetail od : o.getDetail()){
			pstmt2.setInt(1, OrderID);
			
			if(od.getProductID()==-1){              //欄位要放空值，需給-1
                        pstmt2.setNull(2,java.sql.Types.NULL);				
			}else{
			pstmt2.setInt(2, od.getProductID());}
			if(od.getGiftSetID()==-1){              //欄位要放空值，需給-1
                        pstmt2.setNull(3,java.sql.Types.NULL);				
			}else{
			pstmt2.setInt(3, od.getGiftSetID());}
			pstmt2.setFloat(4, od.getSalesPrice());
			pstmt2.setInt(5, od.getQuantity());

			pstmt2.executeUpdate();
			System.out.println("OrderDetail新增成功");
                        }
                        conn.commit();
                        conn.setAutoCommit(true);
                        
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return OrderID;
		
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
		String sql = "UPDATE Orders SET flag = 0 WHERE OrderID = ?";
		try (Connection conn = MySQLconn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, o.getOrderID());
			int count = pstmt.executeUpdate();
			System.out.println(count+"row has been affected");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public Order searchbyID(Integer OrderID) {
		String sql = "SELECT * FROM Orders WHERE OrderID = ? AND flag !=0";
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
		String sql = "SELECT * FROM Orders WHERE flag !=0 ORDER BY OrderID";
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

    @Override
    public ArrayList<Order> getRange(int offset, int count) {
        String sql = "SELECT * FROM Orders WHERE flag !=0 ORDER BY OrderID LIMIT ?,?";
		ArrayList<Order> al = new ArrayList<>();
		try (Connection conn = MySQLconn.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setInt(1,(offset-1));
				pstmt.setInt(2,count);
				ResultSet rs = pstmt.executeQuery();
				
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

    @Override
    public int getSize() {
        String sql = "SELECT count(*) FROM Orders WHERE flag !=0";
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

    @Override
    public ArrayList<Order> findByCustomerID(Integer CustomerID) {
        String sql = "SELECT * FROM Orders WHERE CustomerID = ? AND flag !=0";
		ArrayList<Order> al = new ArrayList<>();
                
		try (Connection conn = MySQLconn.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setInt(1, CustomerID);
			ResultSet rs = pstmt.executeQuery();
			
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
                if(al.isEmpty()){
                    return null;
                }else{
		return al;
                }
    }


}
