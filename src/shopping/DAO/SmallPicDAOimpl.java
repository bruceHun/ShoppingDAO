package shopping.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import shopping.Business.MySQLconn;
import shopping.Class.SmallPic;

public class SmallPicDAOimpl implements SmallPicDAO{

	private int IdCheck() {		
		String sql = "SELECT MAX(SmallPicID) FROM SmallPics";
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
	public int add(SmallPic sp) {
		String sql = "INSERT INTO SmallPics VALUES(null,?,?)";
		try (Connection conn = MySQLconn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

				pstmt.setString(1, sp.getSmallPicName());
				pstmt.setInt(2, sp.getProductID());

				pstmt.executeUpdate();
				System.out.println("SmallPics新增成功");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return IdCheck();
	}

	@Override
	public void update(SmallPic sp) {
		String sql = "UPDATE SmallPics SET SmallPicName = ?, "
				+ "ProductID = ?  WHERE SmallPicID = ?";
			try (Connection conn = MySQLconn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1,sp.getSmallPicName());
			pstmt.setInt(2, sp.getProductID());
			pstmt.setInt(3, sp.getSmallPicID());
			
			pstmt.executeUpdate();
			System.out.println("SmallPic更新成功");
			} catch (SQLException e) {
			System.out.println(e.getMessage());
			}
		
	}

	@Override
	public void delete(SmallPic sp) {
		String sql = "DELETE FROM SmallPics WHERE SmallPicID = ?";
		try (Connection conn = MySQLconn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, sp.getSmallPicID());
			int count = pstmt.executeUpdate();
			System.out.println(count+"row has been affected");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public SmallPic searchbyID(int SmallpicID) {
		String sql = "SELECT * FROM SmallPics WHERE SmallPicID = ?";
		SmallPic sp = new SmallPic();
		try (Connection conn = MySQLconn.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setInt(1, SmallpicID);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
			sp.setSmallPicID(rs.getInt(1));
			sp.setSmallPicName(rs.getString(2));
			sp.setProductID(rs.getInt(3));
			
			return sp;
			
			}else{
			return null;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return sp;
	}

	@Override
	public ArrayList<SmallPic> showAll() {
		String sql = "SELECT * FROM SmallPics ORDER BY SmallPicID";
		ArrayList<SmallPic> al = new ArrayList<>();
		try (Connection conn = MySQLconn.getConnection(); 
				Statement stmt = conn.createStatement(); 
				ResultSet rs = stmt.executeQuery(sql)) {
			
			while(rs.next()){
				al.add(new SmallPic(rs.getInt(1),
									rs.getString(2),
									rs.getInt(3)));
				}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return al;
	}

}
