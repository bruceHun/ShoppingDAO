package shopping.Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.google.appengine.api.utils.SystemProperty;

public class MySQLconn {

    public static Connection getConnection() throws SQLException {

        String url = null; 
        try {
            if (SystemProperty.environment.value()
                    == SystemProperty.Environment.Value.Production) {

                // Connecting from App Engine.
                // Load the class that provides the "jdbc:google:mysql://"
                // prefix.
                Class.forName("com.mysql.jdbc.GoogleDriver");
                url = "jdbc:google:mysql://javalab-1033:us/shopping?user=root"
                        + "&useUnicode=true&characterEncoding=utf8";
            } else {
                // Connecting from an external network.
                Class.forName("com.mysql.jdbc.Driver");
                url = "jdbc:mysql://173.194.86.196:3306/shopping?user=BruceH"
                        + "&useUnicode=true&characterEncoding=utf8";
            }
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        Connection conn = DriverManager.getConnection(url);

        return conn;
    }
}
