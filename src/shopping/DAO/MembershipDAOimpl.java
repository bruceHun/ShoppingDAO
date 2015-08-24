package shopping.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import shopping.Business.MySQLconn;
import shopping.Class.Membership;

public class MembershipDAOimpl implements MembershipDAO{

	private int IdCheck() {		
		String sql = "SELECT MAX(CustomerID) FROM Membership";
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
	public int add(Membership m) {
		String sql = "INSERT INTO Membership VALUES(?,?,?,?)";
		try (Connection conn = MySQLconn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

				pstmt.setInt(1, m.getCustomerID());
				pstmt.setString(2, m.getAccount());
				pstmt.setString(3, m.getPassword());
				pstmt.setByte(4, m.getMembership());

				pstmt.executeUpdate();
				System.out.println("Membership新增成功");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return IdCheck();
		
	}

	@Override
	public void update(Membership m) {
		String sql = "UPDATE Membership SET Account = ?, "
				+ "Password = ?, "
				+ "Membership = ?  WHERE CustomerID = ?";
			try (Connection conn = MySQLconn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, m.getAccount());
				pstmt.setString(2, m.getPassword());
				pstmt.setByte(3, m.getMembership());
				pstmt.setInt(4, m.getCustomerID());
			
				pstmt.executeUpdate();
				System.out.println("Membership更新成功");
			} catch (SQLException e) {
			System.out.println(e.getMessage());
			}
		
	}

	@Override
	public void delete(Membership m) {
		String sql = "DELETE FROM Memebership WHERE CustomerID = ?";
		try (Connection conn = MySQLconn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, m.getCustomerID());
			int count = pstmt.executeUpdate();
			System.out.println(count+"row has been affected");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public Membership searchbyID(int CustomerID) {
		String sql = "SELECT * FROM Membership WHERE CustomerID = ?";
		Membership m = new Membership();
		try (Connection conn = MySQLconn.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setInt(1, CustomerID);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
			m.setCustomerID(rs.getInt(1));
			m.setAccount(rs.getString(2));
			m.setPassword(rs.getString(3));
			m.setMembership(rs.getByte(4));
			
			return m;
			
			}else{
			return null;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return m;
	}

	@Override
	public ArrayList<Membership> showAll() {
		String sql = "SELECT * FROM Membership ORDER BY CustomerID";
		ArrayList<Membership> al = new ArrayList<>();
		try (Connection conn = MySQLconn.getConnection(); 
				Statement stmt = conn.createStatement(); 
				ResultSet rs = stmt.executeQuery(sql)) {
			
			while(rs.next()){
				al.add(new Membership(rs.getInt(1),
									rs.getString(2),
									rs.getString(3),
									rs.getByte(4)));
				}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return al;
	}

	@Override
	public Membership searchbyAccount(String Account) {
		String sql = "SELECT * FROM Membership WHERE Account = ?";
		Membership m = new Membership();
		try (Connection conn = MySQLconn.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setString(1, Account);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
			m.setCustomerID(rs.getInt(1));
			m.setAccount(rs.getString(2));
			m.setPassword(rs.getString(3));
			m.setMembership(rs.getByte(4));
			
			return m;
			
			}else{
			return null;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return m;
	}
	
}
