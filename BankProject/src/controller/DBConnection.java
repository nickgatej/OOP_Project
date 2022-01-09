package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    Connection con = null;
    public static Connection connectDB() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankcustomers", "root", "123 123");
            System.out.println(con);
            return con;
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
