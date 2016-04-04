package by.it.Baranova.JD03;

import java.sql.*;


public class Main {
    public static void main(String[] args) throws SQLException {
        Connection conn;
        Statement st;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

    }
}
