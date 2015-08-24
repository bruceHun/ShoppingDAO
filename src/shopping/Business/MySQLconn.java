package shopping.Business;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLconn {
	public static Connection getConnection() throws SQLException {
        Connection conn = null;
 
        String driverName = "com.mysql.jdbc.Driver";
        
        /*String connString = "jdbc:mysql://localhost:3306/Shopping?"
                + "user=root&password=";*/
        try (FileInputStream f = new FileInputStream("db.properties")){
            Class.forName(driverName);
            Properties pros = new Properties();
            pros.load(f);
            
            String url = pros.getProperty("url");
            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            
            conn = DriverManager.getConnection(url,user,password);

            
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e);
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return conn;
    }
}
