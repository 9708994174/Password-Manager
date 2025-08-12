package JDBCProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {

    public static Connection getMysqlConnection() {

        // MySQL credentials
        String dbUsername = "root";
        String dbPassword = "@Rahul123";

        // MySQL database schema
        String dbSchema = "passwordmanagerdb";

        // JDBC URL
        String url = "jdbc:mysql://localhost:3306/";

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            Connection con = DriverManager.getConnection(url + dbSchema, dbUsername, dbPassword);
            System.out.println("Connection successful!");
            return con;
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver Not Found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL Exception Occurred!");
            e.printStackTrace();
        }

        return null;
    }
}