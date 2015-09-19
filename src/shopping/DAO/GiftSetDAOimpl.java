package shopping.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Types;

import shopping.Business.MySQLconn;
import shopping.Class.GiftSet;

public class GiftSetDAOimpl implements GiftSetDAO{
	
	@Override
	public int add(GiftSet g) {
                int GiftSetID = 0;
		String sql = "INSERT INTO GiftSets VALUES(null,?,?,?,?,?,?,?,?,1)";
                String sql2 = "INSERT INTO BigPics VALUES(null,?,null,?,1)";
                String sql3 = "INSERT INTO SmallPics VALUES(null,?,null,?,1)";
		try (Connection conn = MySQLconn.getConnection(); 
                        PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                        PreparedStatement pstmt2 = conn.prepareStatement(sql2);
                                PreparedStatement pstmt3 = conn.prepareStatement(sql3)) {

                        conn.setAutoCommit(false);
                        
			pstmt.setString(1, g.getGiftSetName());
                        
                        if(g.getID1()!=-1){
                            pstmt.setInt(2, g.getID1());
                        }else{
                            pstmt.setNull(2, Types.NULL);
                        }if(g.getID2()!=-1){
                            pstmt.setInt(3, g.getID2());
                        }else{			
                            pstmt.setNull(3, Types.NULL);
                        }if(g.getID3()!=-1){
                            pstmt.setInt(4, g.getID3());
                        }else{
                            pstmt.setNull(4, Types.NULL);			
                        }if(g.getID4()!=-1){
                            pstmt.setInt(5, g.getID4());
                        }else{
                            pstmt.setNull(5, Types.NULL);			
                        }if(g.getID5()!=-1){
                            pstmt.setInt(6, g.getID5());
                        }else{
                            pstmt.setNull(6, Types.NULL);			
                        }
			
			pstmt.setFloat(7, g.getUnitPrice());
			pstmt.setByte(8, g.getDiscontinued());
			

			pstmt.executeUpdate();
			System.out.println("GiftSet新增成功");
                        
                        ResultSet rs = pstmt.getGeneratedKeys();
                        rs.next();
                        GiftSetID = rs.getInt(1);
                        
                        //設定大圖資料
                    for (int i = 1; i <= g.getBigP().length; i++) {
                        pstmt2.setString(1, "pg_"+GiftSetID+i+".jpg");
                        pstmt2.setInt(2, GiftSetID);
                        
                        pstmt2.executeUpdate();
                        System.out.println("BigPic新增成功");
                    }
                        
                        //設定小圖資料
                        pstmt3.setString(1, "g_"+GiftSetID+".jpg");
                        pstmt3.setInt(2, GiftSetID);
                        
                        pstmt3.executeUpdate();
                        System.out.println("SmallPics新增成功");
        
                        conn.commit();
                        conn.setAutoCommit(true);
                        
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return GiftSetID;
		
	}

	@Override
	public void update(GiftSet g) {
		String sql = "UPDATE GiftSets SET GiftSetName = ?, "
				+ "ID1 = ?, "
				+ "ID2 = ?, "
				+ "ID3 = ?, "
				+ "ID4 = ?, "
				+ "ID5 = ?, "
				+ "UnitPrice = ?, "
				+ "Discontinued = ? WHERE GiftSetID = ?";
			try (Connection conn = MySQLconn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, g.getGiftSetName());
				
                                 if(g.getID1()!=-1){
                                pstmt.setInt(2, g.getID1());
                                }else{
                                    pstmt.setNull(2, Types.NULL);
                                }if(g.getID2()!=-1){
                                    pstmt.setInt(3, g.getID2());
                                }else{			
                                    pstmt.setNull(3, Types.NULL);
                                }if(g.getID3()!=-1){
                                    pstmt.setInt(4, g.getID3());
                                }else{
                                    pstmt.setNull(4, Types.NULL);			
                                }if(g.getID4()!=-1){
                                    pstmt.setInt(5, g.getID4());
                                }else{
                                    pstmt.setNull(5, Types.NULL);			
                                }if(g.getID5()!=-1){
                                    pstmt.setInt(6, g.getID5());
                                }else{
                                    pstmt.setNull(6, Types.NULL);			
                                }
                                
				pstmt.setFloat(7, g.getUnitPrice());
				pstmt.setByte(8, g.getDiscontinued());
				pstmt.setInt(9, g.getGiftSetID());
			
				pstmt.executeUpdate();
				System.out.println("GiftSet更新成功");
			} catch (SQLException e) {
			System.out.println(e.getMessage());
			}
		
	}

	@Override
	public void delete(GiftSet g) {
		String sql = "UPDATE GiftSets SET flag = 0 WHERE GiftSetID = ?";
		try (Connection conn = MySQLconn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, g.getGiftSetID());
			int count = pstmt.executeUpdate();
			System.out.println(count+"row has been affected");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public GiftSet searchbyID(Integer GiftSetID) {
		String sql = "SELECT * FROM GiftSets WHERE GiftSetID = ? AND flag !=0";
		GiftSet g = new GiftSet();
		try (Connection conn = MySQLconn.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setInt(1, GiftSetID);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
			g.setGiftSetID(rs.getInt(1));
			g.setGiftSetName(rs.getString(2));
			g.setID1(rs.getInt(3));
			g.setID2(rs.getInt(4));
			g.setID3(rs.getInt(5));
			g.setID4(rs.getInt(6));
			g.setID5(rs.getInt(7));
			g.setUnitPrice(rs.getFloat(8));
			g.setDiscontinued(rs.getByte(9));
			
			return g;
			
			}else{
			return null;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return g;
	}

	@Override
	public ArrayList<GiftSet> showAll() {
		String sql = "SELECT * FROM GiftSets WHERE flag !=0 ORDER BY GiftSetID";
		ArrayList<GiftSet> al = new ArrayList<>();
		try (Connection conn = MySQLconn.getConnection(); 
				Statement stmt = conn.createStatement(); 
				ResultSet rs = stmt.executeQuery(sql)) {
			
			while(rs.next()){
				al.add(new GiftSet(rs.getInt(1),
									rs.getString(2),
									rs.getInt(3),
									rs.getInt(4),
									rs.getInt(5),
									rs.getInt(6),
									rs.getInt(7),
									rs.getFloat(8),
									rs.getByte(9)));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return al;
	}

    @Override
    public ArrayList<GiftSet> getRange(int offset, int count) {
        String sql = "SELECT * FROM GiftSets WHERE flag !=0 ORDER BY GiftSetID LIMIT ?,?";
		ArrayList<GiftSet> al = new ArrayList<>();
		try (Connection conn = MySQLconn.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setInt(1,(offset-1));
				pstmt.setInt(2,count);
				ResultSet rs = pstmt.executeQuery();
				
			while(rs.next()){
				al.add(new GiftSet(rs.getInt(1),
									rs.getString(2),
									rs.getInt(3),
									rs.getInt(4),
									rs.getInt(5),
									rs.getInt(6),
                                                                        rs.getInt(7),
                                                                        rs.getFloat(8),
                                                                        rs.getByte(9)));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return al;
    }

    @Override
    public int getSize() {
        String sql = "SELECT count(*) FROM GiftSets WHERE flag !=0";
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
