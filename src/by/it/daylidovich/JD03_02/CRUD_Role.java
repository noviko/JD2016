package by.it.daylidovich.JD03_02;

import by.it.daylidovich.JD03_01.ADB;

import java.sql.*;

public class CRUD_Role {
    public static void read() throws SQLException {
        Connection connection  = DriverManager.getConnection(ADB.URL_DB, ADB.USER_DB, ADB.PASSWORD_DB);
        Statement statement = connection.createStatement();
        System.out.println("TABLE ROLE");
        ResultSet resultSet=statement.executeQuery("SELECT * FROM role;");
        while (resultSet.next()){
            String out=resultSet.getInt("id")+" "+resultSet.getString("Role");
            System.out.println(out);
        }
        connection.close();
    }

    public static void create(String role) throws SQLException{
        Connection connection  = DriverManager.getConnection(ADB.URL_DB, ADB.USER_DB, ADB.PASSWORD_DB);
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO Role(idRole, Rolecol) VALUES ('" + role + "')");
        ResultSet resultSet = statement.executeQuery("" +
                "SELECT * " +
                "FROM Role " +
                "WHERE LAST ");
        System.out.print("Added row: ");
        while (resultSet.next()){
            String out=resultSet.getInt("id")+" "+resultSet.getString("Role");
            System.out.println(out);
        }
        connection.close();
    }

    public static void update(int number, String role) throws SQLException{
        Connection connection  = DriverManager.getConnection(ADB.URL_DB, ADB.USER_DB, ADB.PASSWORD_DB);
        Statement statement = connection.createStatement();
        statement.executeUpdate("UPDATE role SET Role='" + role + "' WHERE id=" + number);
        ResultSet resultSet=statement.executeQuery("" +
                "SELECT * " +
                "FROM role " +
                "WHERE id=" + number);
        System.out.print("Changed row: ");
        while (resultSet.next()){
            String out=resultSet.getInt("id")+" "+resultSet.getString("Role");
            System.out.println(out);
        }
        connection.close();
    }

    public static void delete(int number) throws SQLException{
        Connection connection  = DriverManager.getConnection(ADB.URL_DB, ADB.USER_DB, ADB.PASSWORD_DB);
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM role WHERE id=" + number);
        ResultSet resultSet=statement.executeQuery("" +
                "SELECT * " +
                "FROM role ");
        System.out.println("Left rows: ");
        while (resultSet.next()){
            String out=resultSet.getInt("id")+" "+resultSet.getString("Role");
            System.out.println(out);
        }
        connection.close();
    }
}
