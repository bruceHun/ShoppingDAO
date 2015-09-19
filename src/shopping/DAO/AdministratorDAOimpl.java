package shopping.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import shopping.Business.MySQLconn;
import shopping.Class.Administrator;

public class AdministratorDAOimpl implements AdministratorDAO{

	private String AccCheck() {		
		String sql = "SELECT MAX(Account) FROM Administrators";
		String Acc = null;
		try(Connection conn = MySQLconn.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
			
			rs.next();
			Acc = rs.getString(1);
				
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return Acc;
	}
	
	@Override
	public String add(Administrator a) {
		String sql = "INSERT INTO Administrators VALUES(?,?,?,1)";
		try (Connection conn = MySQLconn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

				pstmt.setString(1, a.getAccount());
				pstmt.setString(2, a.getPassword());
				pstmt.setString(3, a.getLevel());

				pstmt.executeUpdate();
				System.out.println("Administrator新增成功");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		return AccCheck();
		
	}

	@Override
	public void update(Administrator a) {
		String sql = "UPDATE Administrators SET Password = ?, "
				+ "Level = ?  WHERE Account = ?";
			try (Connection conn = MySQLconn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1,a.getPassword());
			pstmt.setString(2, a.getLevel());
			pstmt.setString(3, a.getAccount());
			
			pstmt.executeUpdate();
			System.out.println("Administrator更新成功");
			} catch (SQLException e) {
			System.out.println(e.getMessage());
			}
		
	}

	@Override
	public void delete(Administrator a) {
		String sql = "UPDATE Administrators SET flag = 0 WHERE Account = ?";
		try (Connection conn = MySQLconn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, a.getAccount());
			int count = pstmt.executeUpdate();
			System.out.println(count+"row has been affected");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public Administrator searchbyAccount(String Account) {
		
		String sql = "SELECT * FROM Administrators WHERE Account = ? AND flag !=0";
		Administrator a = new Administrator();
		try (Connection conn = MySQLconn.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setString(1, Account);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
			a.setAccount(rs.getString(1));
			a.setPassword(rs.getString(2));
			a.setLevel(rs.getString(3));
			
			return a;
			
			}else{
			return null;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return a;
	}

	@Override
	public ArrayList<Administrator> showAll() {
		String sql = "SELECT * FROM Administrators WHERE Account != '@root' AND flag !=0 ORDER BY Level";
		ArrayList<Administrator> al = new ArrayList<>();
		try (Connection conn = MySQLconn.getConnection(); 
				Statement stmt = conn.createStatement(); 
				ResultSet rs = stmt.executeQuery(sql)) {
			
			while(rs.next()){
				al.add(new Administrator(rs.getString(1),
									rs.getString(2),
									rs.getString(3)));
				}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return al;
	}

   @Override
	public ArrayList<Administrator> getRange(int offset, int count) {
		String sql = "SELECT * FROM Administrators WHERE Account != '@root' AND flag !=0 ORDER BY Level LIMIT ?,?";
		ArrayList<Administrator> al = new ArrayList<>();
		try (Connection conn = MySQLconn.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setInt(1,(offset-1));
				pstmt.setInt(2,count);
				ResultSet rs = pstmt.executeQuery();
				
			while(rs.next()){
				al.add(new Administrator(rs.getString(1),
									rs.getString(2),
									rs.getString(3)));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return al;
	}

	@Override
	public int getSize() {
			String sql = "SELECT count(*) FROM Administrators WHERE flag !=0";
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
