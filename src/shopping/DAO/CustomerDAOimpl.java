package shopping.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import shopping.Business.MySQLconn;
import shopping.Class.Customer;

public class CustomerDAOimpl implements CustomerDAO {

	private int IdCheck() {		
		String sql = "SELECT MAX(CustomerID) FROM Customers";
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
	public int add(Customer c) {
		String sql = "INSERT INTO Customers VALUES(null,?,?,?,?,?,?,?,?,?,?)";
		try (Connection conn = MySQLconn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, c.getCustomerName());
			pstmt.setString(2, c.getPersonalID());
			pstmt.setByte(3, c.getGender());
			pstmt.setString(4, c.getBirthDate());
			pstmt.setString(5, c.getPhone());
			pstmt.setString(6, c.getCelPhone());
			pstmt.setString(7, c.getAddress());
			pstmt.setString(8, c.getEmail());
			pstmt.setString(9, c.getCustomerType());
			pstmt.setInt(10, c.getDiscountID());

			pstmt.executeUpdate();
			System.out.println("Customer新增成功");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return IdCheck();

	}

	@Override
	public void update(Customer c) {
		String sql = "UPDATE Customers SET CustomerName = ?, "
										+ "PersonalID = ?, "
										+ "Gender = ?"
										+ "BirthDate = ?, "
										+ "Phone = ?, "
										+ "CelPhone = ?, "
										+ "Address = ?, "
										+ "Email = ?, "
										+ "CustomerType = ?, "
										+ "DiscountID = ?  WHERE CustomerID = ?";
		try (Connection conn = MySQLconn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1,c.getCustomerName());
			pstmt.setString(2, c.getPersonalID());
			pstmt.setByte(3, c.getGender());
			pstmt.setString(4, c.getBirthDate());
			pstmt.setString(5, c.getPhone());
			pstmt.setString(6, c.getCelPhone());
			pstmt.setString(7, c.getAddress());
			pstmt.setString(8, c.getEmail());
			pstmt.setString(9, c.getCustomerType());
			pstmt.setInt(10, c.getDiscountID());
			pstmt.setInt(11, c.getCustomerID());
			
			pstmt.executeUpdate();
			System.out.println("Customer更新成功");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void delete(Customer c) {
		String sql = "DELETE FROM Customers WHERE CustomerID = ?";
		try (Connection conn = MySQLconn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, c.getCustomerID());
			int count = pstmt.executeUpdate();
			System.out.println(count+"row has been affected");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public Customer searchbyID(int CustomerID) {
		String sql = "SELECT * FROM Customers WHERE CustomerID = ?";
		Customer c = new Customer();
		try (Connection conn = MySQLconn.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setInt(1, CustomerID);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
			c.setCustomerID(rs.getInt(1));
			c.setCustomerName(rs.getString(2));
			c.setPersonalID(rs.getString(3));
			c.setGender(rs.getByte(4));
			c.setBirthDate(rs.getString(5));
			c.setPhone(rs.getString(6));
			c.setCelPhone(rs.getString(7));
			c.setAddress(rs.getString(8));
			c.setEmail(rs.getString(9));
			c.setCustomerType(rs.getString(10));
			c.setDiscountID(rs.getInt(11));
			
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
	public ArrayList<Customer> showAll() {
		String sql = "SELECT * FROM Customers ORDER BY CustomerID";
		ArrayList<Customer> al = new ArrayList<>();
		try (Connection conn = MySQLconn.getConnection(); 
				Statement stmt = conn.createStatement(); 
				ResultSet rs = stmt.executeQuery(sql)) {
			
			while(rs.next()){
				al.add(new Customer(rs.getInt(1),
									rs.getString(2),
									rs.getString(3),
									rs.getByte(4),
									rs.getString(5),
									rs.getString(6),
									rs.getString(7),
									rs.getString(8),
									rs.getString(9),
									rs.getString(10),
									rs.getInt(11)));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return al;
	}

}
