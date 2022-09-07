
package datastructures;
//import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  Purpose: Understand JDBC.
 *
 *  References:
 *  - tutorialspoint.com/jdbc
 *  - javatpoint.com/java-jdbc
 *  - mkyong.com/jdbc/how-to-connect-to-mysql-with-jdbc-driver-java
 *
 */
public class MySQLJDBC {

    public static void main(String[] args) {
        Connection conn = null;

        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost/qrcode?" +
                            "user=root&password=passme");

            // Do something with the Connection

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }//end main
}//end FirstExample