package shopping.Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLconn {
	public static Connection getConnection() throws SQLException {
        Connection conn = null;
 
        String driverName = "com.mysql.jdbc.Driver";
        String connString = "jdbc:mysql://localhost:3306/Shopping?"
                + "user=root&password=";
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(connString);

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e);
        }
        return conn;
    }
}
