package shopping.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import shopping.Business.MySQLconn;
import shopping.Class.BigPic;

public class BigPIcDAOimpl implements BigPicDAO{

	private int IdCheck() {		
		String sql = "SELECT MAX(BigPicID) FROM BigPics";
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
	public int add(BigPic bp) {
		String sql = "INSERT INTO BigPics VALUES(null,?,?)";
		try (Connection conn = MySQLconn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

				pstmt.setString(1, bp.getBigPicName());
				pstmt.setInt(2, bp.getProductID());

				pstmt.executeUpdate();
				System.out.println("BigPic新增成功");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return IdCheck();
		
	}

	@Override
	public void update(BigPic bp) {
		String sql = "UPDATE BigPics SET BigPicName = ?, "
				+ "ProductID = ?  WHERE BigPicID = ?";
			try (Connection conn = MySQLconn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1,bp.getBigPicName());
			pstmt.setInt(2, bp.getProductID());
			pstmt.setInt(3, bp.getBigPicID());
			
			pstmt.executeUpdate();
			System.out.println("BigPic更新成功");
			} catch (SQLException e) {
			System.out.println(e.getMessage());
			}
		
	}

	@Override
	public void delete(BigPic bp) {
		String sql = "DELETE FROM BigPics WHERE BigPicID = ?";
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
		String sql = "SELECT * FROM BigPics WHERE BigPicID = ?";
		BigPic bp = new BigPic();
		try (Connection conn = MySQLconn.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setInt(1, BigPicID);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
			bp.setBigPicID(rs.getInt(1));
			bp.setBigPicName(rs.getString(2));
			bp.setProductID(rs.getInt(3));
			
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
		String sql = "SELECT * FROM BigPics ORDER BY BigPicID";
		ArrayList<BigPic> al = new ArrayList<>();
		try (Connection conn = MySQLconn.getConnection(); 
				Statement stmt = conn.createStatement(); 
				ResultSet rs = stmt.executeQuery(sql)) {
			
			while(rs.next()){
				al.add(new BigPic(rs.getInt(1),
									rs.getString(2),
									rs.getInt(3)));
				}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return al;
	}

}
