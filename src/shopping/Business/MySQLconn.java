package shopping.Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLconn {
	public static Connection getConnection() throws SQLException {
        Connection conn = null;
 
        String driverName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/Shopping";
        String user = "root";
        String password = "123456";
        //String connString = "jdbc:mysql://localhost:3306/Shopping?"
                //+ "user=root&password=123456";
        /*try (FileInputStream f = new FileInputStream("db.properties")){
            Class.forName(driverName);
            Properties pros = new Properties();
            pros.load(f);
            
            String url = pros.getProperty("url");
            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            
            conn = DriverManager.getConnection(url,user,password);*/
        	
        try{
        	Class.forName(driverName);
        	conn = DriverManager.getConnection(url, user, password);

            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
        return conn;
    }
}
