
package shopping.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import shopping.Business.MySQLconn;
import shopping.Class.Cart;

public class CartDAOimpl implements CartDAO {
    
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
    public int add(Cart c) {     
            String sql = "INSERT INTO Cart VALUES(null,?,?,?,?,?)";
            try (Connection conn = MySQLconn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

                    pstmt.setString(1, c.getSession());
                    pstmt.setInt(2, c.getProductID());
                    pstmt.setInt(3, c.getGiftSetID());
                    pstmt.setInt(4, c.getQuantity());
                    pstmt.setInt(5, c.getCustomerID());

                    pstmt.executeUpdate();
                    System.out.println("Cart新增成功");
            } catch (SQLException e) {
                    System.out.println(e.getMessage());
            }
            return IdCheck();
    }

    @Override
    public void update(Cart c) {
        String sql = "UPDATE Inventory SET "
				+ "ProductID = ?, "
				+ "GiftSetID = ?, "
				+ "Quantity = ?, "
				+ "CustomerID = ? WHERE Session = ?";
			try (Connection conn = MySQLconn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setInt(1, c.getProductID());
				pstmt.setInt(2, c.getGiftSetID());
				pstmt.setInt(3, c.getQuantity());
				pstmt.setInt(4, c.getCustomerID());
				pstmt.setString(5, c.getSession());
			
				pstmt.executeUpdate();
				System.out.println("Cart更新成功");
			} catch (SQLException e) {
			System.out.println(e.getMessage());
			}
    }

    @Override
    public void delete(Cart c) {
        String sql = "DELETE FROM Cart WHERE Session = ?";
		try (Connection conn = MySQLconn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, c.getSession());
			int count = pstmt.executeUpdate();
			System.out.println(count+"row has been affected");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
    }

    @Override
    public Cart searchbySession(String Session) {
        String sql = "SELECT * FROM Cart WHERE Session = ?";
		Cart c = new Cart();
		try (Connection conn = MySQLconn.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setString(1, Session);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
                        c.setID(rs.getInt(1));
			c.setSession(rs.getString(2));
                        c.setProductID(rs.getInt(3));
                        c.setGiftSetID(rs.getInt(4));
                        c.setQuantity(rs.getInt(5));
                        c.setCustomerID(rs.getInt(6));
			
			return c;
			
			}else{
			return null;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return c;
    }

    @Override
    public ArrayList<Cart> showAll() {
        String sql = "SELECT * FROM Cart ORDER BY ID";
		ArrayList<Cart> al = new ArrayList<>();
		try (Connection conn = MySQLconn.getConnection(); 
				Statement stmt = conn.createStatement(); 
				ResultSet rs = stmt.executeQuery(sql)) {
			
			while(rs.next()){
				al.add(new Cart(rs.getInt(1),
									rs.getString(2),
									rs.getInt(3),
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
    public ArrayList<Cart> getRange(int offset, int count) {
        String sql = "SELECT * FROM Cart ORDER BY ID LIMIT ?,?";
		ArrayList<Cart> al = new ArrayList<>();
		try (Connection conn = MySQLconn.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setInt(1,(offset-1));
				pstmt.setInt(2,count);
				ResultSet rs = pstmt.executeQuery();
				
			while(rs.next()){
				al.add(new Cart(rs.getInt(1),
									rs.getString(2),
									rs.getInt(3),
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
        String sql = "SELECT count(*) FROM Cart";
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
