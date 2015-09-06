package shopping.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import shopping.Business.MySQLconn;
import shopping.Class.Product;

public class ProductDAOimpl implements ProductDAO{

	@Override
	public int add(Product p) {
                int ProductID = 0;
		String sql1 = "INSERT INTO Products VALUES(null,?,?,?,?,?,?,?,?)";
                String sql2 = "INSERT INTO Inventory VALUES(null,?,?,?,?,?)";
		try (Connection conn = MySQLconn.getConnection(); 
				PreparedStatement pstmt1 = conn.prepareStatement(sql1,Statement.RETURN_GENERATED_KEYS);
                                PreparedStatement pstmt2 = conn.prepareStatement(sql2)) {
                    
                        conn.setAutoCommit(false);

			pstmt1.setString(1, p.getBarcode());
			pstmt1.setInt(2, p.getCategoryID());
			pstmt1.setString(3, p.getProductName());
			pstmt1.setString(4, p.getProductUnit());
			pstmt1.setString(5, p.getCapacity());
			pstmt1.setFloat(6, p.getUnitPrice());
			pstmt1.setByte(7, p.getDiscontinued());
			pstmt1.setString(8, p.getDescription());

			pstmt1.executeUpdate();
			System.out.println("Product新增成功");
                        ResultSet rs = pstmt1.getGeneratedKeys();
                        rs.next();
                        ProductID = rs.getInt(1);
                        
                        

			pstmt2.setInt(1, ProductID);
			pstmt2.setFloat(2, p.getStock().getCost());
			pstmt2.setInt(3, p.getStock().getUnitsInStock());
			pstmt2.setInt(4, p.getStock().getUnitsOnOrder());
			pstmt2.setInt(5, p.getStock().getSaftyStock());

			pstmt2.executeUpdate();
			System.out.println("Inventory新增成功");
                        
                        conn.commit();
                        conn.setAutoCommit(true);
                        
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return ProductID;
		
	}

	@Override
	public void update(Product p) {
		String sql1 = "UPDATE Products SET Barcode = ?, "
				+ "CategoryID = ?, "
				+ "ProductName = ?, "
				+ "ProductUnit = ?, "
				+ "Capacity = ?, "
				+ "UnitPrice = ?, "
				+ "Discontinued = ?, "
				+ "Description = ? WHERE ProductID = ?";
                
                 String sql2 = "UPDATE Inventory SET ProductID = ?, "
				+ "Cost = ?, "
				+ "UnitsInStock = ?, "
				+ "UnitsOnOrder = ?, "
				+ "SafetyStock = ? WHERE StockNumber = ?";
                 
			try (Connection conn = MySQLconn.getConnection(); 
					PreparedStatement pstmt1 = conn.prepareStatement(sql1);
                                        PreparedStatement pstmt2 = conn.prepareStatement(sql2)) {
                            
                                conn.setAutoCommit(false);
                            
				pstmt1.setString(1, p.getBarcode());
				pstmt1.setInt(2, p.getCategoryID());
				pstmt1.setString(3, p.getProductName());
				pstmt1.setString(4, p.getProductUnit());
				pstmt1.setString(5, p.getCapacity());
				pstmt1.setFloat(6, p.getUnitPrice());
				pstmt1.setByte(7, p.getDiscontinued());
				pstmt1.setString(8, p.getDescription());
				pstmt1.setInt(9, p.getProductID());

				pstmt1.executeUpdate();
				System.out.println("Product更新成功");
                                
                               
			
				pstmt2.setInt(1, p.getStock().getProductID());
				pstmt2.setFloat(2, p.getStock().getCost());
				pstmt2.setInt(3, p.getStock().getUnitsInStock());
				pstmt2.setInt(4, p.getStock().getUnitsOnOrder());
				pstmt2.setInt(5, p.getStock().getSaftyStock());
				pstmt2.setInt(6, p.getStock().getStockNumber());
			
				pstmt2.executeUpdate();
				System.out.println("Inventory更新成功");
                                
                                conn.commit();
                                conn.setAutoCommit(true);
                                
				} catch (SQLException e) {
				System.out.println(e.getMessage());
				}
		
	}

	@Override
	public void delete(Product p) {
		String sql = "DELETE FROM Products WHERE ProductID = ?";
		try (Connection conn = MySQLconn.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, p.getProductID());
			int count = pstmt.executeUpdate();
			System.out.println(count+" row has been affected");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public Product searchbyID(Integer ProductID) {
		String sql = "SELECT * FROM Products WHERE ProductID = ?";
		Product p = new Product();
		try (Connection conn = MySQLconn.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setInt(1, ProductID);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
			p.setProductID(rs.getInt(1));
			p.setBarcode(rs.getString(2));
			p.setCategoryID(rs.getInt(3));
			p.setProductName(rs.getString(4));
			p.setProductUnit(rs.getString(5));
			p.setCapacity(rs.getString(6));
			p.setUnitPrice(rs.getFloat(7));
			p.setDiscontinued(rs.getByte(8));
			p.setDescription(rs.getString(9));
			
			return p;
			
			}else{
			return null;
                        }

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return p;
	}

	@Override
	public ArrayList<Product> showAll() {
		String sql = "SELECT * FROM Products ORDER BY ProductID";
		ArrayList<Product> al = new ArrayList<>();
		try (Connection conn = MySQLconn.getConnection(); 
				Statement stmt = conn.createStatement(); 
				ResultSet rs = stmt.executeQuery(sql)) {
			
			while(rs.next()){
				al.add(new Product(rs.getInt(1),
									rs.getString(2),
									rs.getInt(3),
									rs.getString(4),
									rs.getString(5),
									rs.getString(6),
									rs.getFloat(7),
									rs.getByte(8),
									rs.getString(9)));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return al;
	}

	@Override
	public ArrayList<Product> getRange(int offset, int count) {
		String sql = "SELECT * FROM Products ORDER BY ProductID LIMIT ?,?"; 
		ArrayList<Product> al = new ArrayList<>();
		try (Connection conn = MySQLconn.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setInt(1,(offset-1)); //offset 為起始點，會從後一號開始，所以要包含要-1
				pstmt.setInt(2,count);
				ResultSet rs = pstmt.executeQuery();
				
			while(rs.next()){
				al.add(new Product(rs.getInt(1),
									rs.getString(2),
									rs.getInt(3),
									rs.getString(4),
									rs.getString(5),
									rs.getString(6),
									rs.getFloat(7),
									rs.getByte(8),
									rs.getString(9)));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return al;
	}

	@Override
	public int getSize() {
			String sql = "SELECT count(*) FROM Products";
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
    public ArrayList<Product> findByName(String ProductName) {
        		String sql = "SELECT * FROM Products WHERE ProductName = ?";
		ArrayList<Product> al = new ArrayList<>();
                
		try (Connection conn = MySQLconn.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, ProductName);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				al.add(new Product(rs.getInt(1),
									rs.getString(2),
									rs.getInt(3),
									rs.getString(4),
									rs.getString(5),
									rs.getString(6),
									rs.getFloat(7),
									rs.getByte(8),
									rs.getString(9)));
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

    @Override
    public ArrayList<Product> findByCategoryID(int CategoryID) {
        String sql = "SELECT * FROM Products WHERE CategoryID = ?";
		ArrayList<Product> al = new ArrayList<>();
                
		try (Connection conn = MySQLconn.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setInt(1, CategoryID);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				al.add(new Product(rs.getInt(1),
									rs.getString(2),
									rs.getInt(3),
									rs.getString(4),
									rs.getString(5),
									rs.getString(6),
									rs.getFloat(7),
									rs.getByte(8),
									rs.getString(9)));
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
