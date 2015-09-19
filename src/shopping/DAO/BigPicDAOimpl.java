package shopping.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import shopping.Business.MySQLconn;
import shopping.Class.BigPic;

public class BigPicDAOimpl implements BigPicDAO{
	
	@Override
	public int add(BigPic bp) {
                int BigPicID=0;
		String sql = "INSERT INTO BigPics VALUES(null,?,?,?,1)";
		try (Connection conn = MySQLconn.getConnection(); 
                        PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {

				pstmt.setString(1, bp.getBigPicName());
                                
                                if(bp.getProductID()==-1){              //欄位要放空值，需給-1
                                pstmt.setNull(2,java.sql.Types.NULL);				
                                }else{
                                pstmt.setInt(2, bp.getProductID());}
                                
				if(bp.getGiftSetID()==-1){
                                pstmt.setNull(3, java.sql.Types.NULL);
                                }else{
                                pstmt.setInt(3, bp.getGiftSetID());}

				pstmt.executeUpdate();
				System.out.println("BigPic新增成功");
                                
                                ResultSet rs = pstmt.getGeneratedKeys();
                                rs.next();
                                BigPicID = rs.getInt(1);
                                
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return BigPicID;
		
	}

	@Override
	public void update(BigPic bp) {
		String sql = "UPDATE BigPics SET BigPicName = ?, "
				+ "ProductID = ?, "
                                + "GiftSetID = ? WHERE BigPicID = ?";
			try (Connection conn = MySQLconn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1,bp.getBigPicName());
                        
			if(bp.getProductID()==-1){              //欄位要放空值，需給-1
                        pstmt.setNull(2,java.sql.Types.NULL);				
                        }else{
                        pstmt.setInt(2, bp.getProductID());}

                        if(bp.getGiftSetID()==-1){
                        pstmt.setNull(3, java.sql.Types.NULL);
                        }else{
                        pstmt.setInt(3, bp.getGiftSetID());}
			
			pstmt.executeUpdate();
			System.out.println("BigPic更新成功");
			} catch (SQLException e) {
			System.out.println(e.getMessage());
			}
		
	}

	@Override
	public void delete(BigPic bp) {
		String sql = "UPDATE BigPics SET flag = 0 WHERE BigPicID = ?";
		try (Connection conn = MySQLconn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, bp.getBigPicID());
			int count = pstmt.executeUpdate();
			System.out.println(count+"row has been affected");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	@Override
	public BigPic searchbyID(int BigPicID) {
		String sql = "SELECT * FROM BigPics WHERE BigPicID = ? AND flag !=0";
		BigPic bp = new BigPic();
		try (Connection conn = MySQLconn.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setInt(1, BigPicID);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
			bp.setBigPicID(rs.getInt(1));
			bp.setBigPicName(rs.getString(2));
			bp.setProductID(rs.getInt(3));
                        bp.setGiftSetID(rs.getInt(4));
			
			return bp;
			
			}else{
			return null;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return bp;

	}

	@Override
	public ArrayList<BigPic> showAll() {
		String sql = "SELECT * FROM BigPics WHERE flag !=0 ORDER BY BigPicID";
		ArrayList<BigPic> al = new ArrayList<>();
		try (Connection conn = MySQLconn.getConnection(); 
				Statement stmt = conn.createStatement(); 
				ResultSet rs = stmt.executeQuery(sql)) {
			
			while(rs.next()){
				al.add(new BigPic(rs.getInt(1),
									rs.getString(2),
									rs.getInt(3),
                                                                        rs.getInt(4)));
				}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return al;
	}

}
