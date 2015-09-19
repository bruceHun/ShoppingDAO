
package shopping.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import shopping.Business.MySQLconn;
import shopping.Class.DeliveryDetail;

public class DeliveryDetailDAOimpl implements DeliveryDetailDAO{

    @Override
    public int add(DeliveryDetail dd) {
                int ID = 0;
		String sql = "INSERT INTO DeliveryDetails VALUES(null,?,?,?,?,?,?,?,?,1)";
		try (Connection conn = MySQLconn.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {

			pstmt.setInt(1, dd.getOrderID());
			pstmt.setString(2, dd.getAddresseeName());
			pstmt.setString(3, dd.getPhone());
			pstmt.setString(4, dd.getCelPhone());
			pstmt.setString(5, dd.getAddress());
			pstmt.setString(6, dd.getTime());
			pstmt.setString(7, dd.getDeliveryMethod());
			pstmt.setInt(8, dd.getFee());

			pstmt.executeUpdate();
			System.out.println("DeliveryDetail新增成功");
                        ResultSet rs = pstmt.getGeneratedKeys();
                        rs.next();
                        ID = rs.getInt(1);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return ID;
    }

    @Override
    public void update(DeliveryDetail dd) {
        String sql = "UPDATE DeliveryDetails SET OrderID = ?, "
				+ "AddresseeName = ?, "
				+ "Phone = ?, "
				+ "CelPhone = ?, "
				+ "Address = ?, "
				+ "Time = ?, "
				+ "DeliveryMethod = ?, "
				+ "Fee = ? WHERE ID = ?";
			try (Connection conn = MySQLconn.getConnection(); 
					PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setInt(1, dd.getOrderID());
				pstmt.setString(2, dd.getAddresseeName());
				pstmt.setString(3, dd.getPhone());
				pstmt.setString(4, dd.getCelPhone());
				pstmt.setString(5, dd.getAddress());
				pstmt.setString(6, dd.getTime());
				pstmt.setString(7, dd.getDeliveryMethod());
				pstmt.setInt(8, dd.getFee());
				pstmt.setInt(9, dd.getID());

				pstmt.executeUpdate();
				System.out.println("DeliveryDetail更新成功");
				} catch (SQLException e) {
				System.out.println(e.getMessage());
				}
    }

    @Override
    public void delete(DeliveryDetail dd) {
        String sql = "UPDATE DeliveryDetails SET flag = 0 WHERE ID = ?";
		try (Connection conn = MySQLconn.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, dd.getID());
			int count = pstmt.executeUpdate();
			System.out.println(count+" row has been affected");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
    }

    @Override
    public DeliveryDetail searchbyID(Integer ID) {
        String sql = "SELECT * FROM DeliveryDetails WHERE ID = ? AND flag !=0";
		DeliveryDetail dd = new DeliveryDetail();
		try (Connection conn = MySQLconn.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setInt(1, ID);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
			dd.setID(rs.getInt(1));
                        dd.setOrderID(rs.getInt(2));
                        dd.setAddresseeName(rs.getString(3));
                        dd.setPhone(rs.getString(4));
                        dd.setCelPhone(rs.getString(5));
                        dd.setAddress(rs.getString(6));
                        dd.setTime(rs.getString(7));
                        dd.setDeliveryMethod(rs.getString(8));
                        dd.setFee(rs.getInt(9));
			
			return dd;
			
			}else{
			return null;
                        }

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dd;
    }

    @Override
    public ArrayList<DeliveryDetail> showAll() {
        String sql = "SELECT * FROM DeliveryDetails WHERE flag !=0 ORDER BY ID";
		ArrayList<DeliveryDetail> al = new ArrayList<>();
		try (Connection conn = MySQLconn.getConnection(); 
				Statement stmt = conn.createStatement(); 
				ResultSet rs = stmt.executeQuery(sql)) {
			
			while(rs.next()){
				al.add(new DeliveryDetail(rs.getInt(1),
									rs.getInt(2),
									rs.getString(3),
									rs.getString(4),
									rs.getString(5),
									rs.getString(6),
									rs.getString(7),
									rs.getString(8),
									rs.getInt(9)));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return al;
    }

    @Override
    public ArrayList<DeliveryDetail> getRange(int offset, int count) {
        String sql = "SELECT * FROM DeliveryDetails WHERE flag !=0 ORDER BY ID LIMIT ?,?";
		ArrayList<DeliveryDetail> al = new ArrayList<>();
		try (Connection conn = MySQLconn.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setInt(1,(offset-1));
				pstmt.setInt(2,count);
				ResultSet rs = pstmt.executeQuery();
				
			while(rs.next()){
				al.add(new DeliveryDetail(rs.getInt(1),
									rs.getInt(2),
									rs.getString(3),
									rs.getString(4),
									rs.getString(5),
									rs.getString(6),
									rs.getString(7),
									rs.getString(8),
									rs.getInt(9)));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return al;
    }

    @Override
    public int getSize() {
        String sql = "SELECT count(*) FROM DeliveryDetails WHERE flag !=0";
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
    public ArrayList<DeliveryDetail> searchbyOrderID(Integer OrderID) {
        String sql = "SELECT * FROM DeliveryDetails WHERE OrderID = ? AND flag !=0";
		ArrayList<DeliveryDetail> al = new ArrayList<>();
                
		try (Connection conn = MySQLconn.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setInt(1, OrderID);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				al.add(new DeliveryDetail(rs.getInt(1),
									rs.getInt(2),
									rs.getString(3),
									rs.getString(4),
									rs.getString(5),
									rs.getString(6),
									rs.getString(7),
									rs.getString(8),
									rs.getInt(9)));
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
