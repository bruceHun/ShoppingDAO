
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
    	
    @Override
    public int add(Cart c) {     
            int ID = 0;
            String sql = "INSERT INTO Cart VALUES(null,?,?,?,?,?,?,?,?,?,?,?,?)";
            try (Connection conn = MySQLconn.getConnection(); 
                    PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {

                    pstmt.setString(1, c.getSession());
                    pstmt.setInt(2, c.getProductID());
                    pstmt.setString(3, c.getProductName());
                    pstmt.setInt(4, c.getProductUnit());
                    pstmt.setString(5, c.getCapacity());
                    pstmt.setFloat(6, c.getUnitPrice());
                    pstmt.setInt(7, c.getSmallPicID());
                    pstmt.setString(8, c.getGiftSetName());
                    pstmt.setFloat(9, c.getGiftSetUnitPrice());
                    pstmt.setInt(10, c.getQuantity());
                    pstmt.setInt(11, c.getCustomerID());
                    pstmt.setFloat(12, c.getDiscount());

                    pstmt.executeUpdate();
                    System.out.println("Cart新增成功");
                    
                    ResultSet rs = pstmt.getGeneratedKeys();
                        rs.next();
                        ID = rs.getInt(1);
                    
            } catch (SQLException e) {
                    System.out.println(e.getMessage());
            }
            return ID;
    }

    @Override
    public void update(Cart c) {
        String sql = "UPDATE Inventory SET "
                                + "Session = ?, "       //1
				+ "ProductID = ?, "     //2
                                + "ProductName = ?, "   //3
                                + "ProductUnit = ?, "   //4
                                + "Capacity = ?, "      //5
                                + "UnitPrice = ?, "     //6
				+ "SmallPicID = ?, "    //7
                                + "GiftSetName = ?, "   //8
                                + "GiftSetUnitPrice = ?, "  //9
				+ "Quantity = ?, "      //10
				+ "CustomerID = ?, "    //11
                                + "Discount = ?, "      //12
                                + "WHERE ID = ?";       //13
			try (Connection conn = MySQLconn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, c.getSession());
                                pstmt.setInt(2, c.getProductID());
                                pstmt.setString(3, c.getProductName());
                                pstmt.setInt(4, c.getProductUnit());
                                pstmt.setString(5, c.getCapacity());
                                pstmt.setFloat(6, c.getUnitPrice());
                                pstmt.setInt(7, c.getSmallPicID());
                                pstmt.setString(8, c.getGiftSetName());
                                pstmt.setFloat(9, c.getGiftSetUnitPrice());
                                pstmt.setInt(10, c.getQuantity());
                                pstmt.setInt(11, c.getCustomerID());
                                pstmt.setFloat(12, c.getDiscount());
				pstmt.setInt(13, c.getID());
			
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
                        c.setProductName(rs.getString(4));
                        c.setProductUnit(rs.getInt(5));
                        c.setCapacity(rs.getString(6));
                        c.setUnitPrice(rs.getFloat(7));
                        c.setSmallPicID(rs.getInt(8));
                        c.setGiftSetName(rs.getString(9));
                        c.setGiftSetUnitPrice(rs.getFloat(10));
                        c.setQuantity(rs.getInt(11));
                        c.setCustomerID(rs.getInt(12));
                        c.setDiscount(rs.getFloat(13));
                        
			
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
									rs.getString(4),
									rs.getInt(5),
									rs.getString(6),
                                                                        rs.getFloat(7),
                                                                        rs.getInt(8),
                                                                        rs.getString(9),
                                                                        rs.getFloat(10),
                                                                        rs.getInt(11),
                                                                        rs.getInt(12),
                                                                        rs.getFloat(13)));
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
									rs.getString(4),
									rs.getInt(5),
									rs.getString(6),
                                                                        rs.getFloat(7),
                                                                        rs.getInt(8),
                                                                        rs.getString(9),
                                                                        rs.getFloat(10),
                                                                        rs.getInt(11),
                                                                        rs.getInt(12),
                                                                        rs.getFloat(13)));
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
