package by.it.daylidovich.JD03_02.A_crud;

import by.it.daylidovich.JD03_01.ADB;

import java.sql.*;

public class CRUD_Role {
    public static void read() throws SQLException {
        Connection connection  = DriverManager.getConnection(ADB.URL_DB, ADB.USER_DB, ADB.PASSWORD_DB);
        Statement statement = connection.createStatement();
        System.out.println("Table Role:");
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
        statement.executeUpdate("INSERT INTO role(Role) VALUES ('" + role + "')");
        ResultSet resultSet = statement.executeQuery("SELECT * FROM role ORDER BY id DESC LIMIT 1");
        System.out.print("Added: ");
        while (resultSet.next()){
            String out=resultSet.getInt("id")+" "+resultSet.getString("Role");
            System.out.println(out);
        }
        connection.close();
    }

    public static void update(int id, String role) throws SQLException{
        Connection connection  = DriverManager.getConnection(ADB.URL_DB, ADB.USER_DB, ADB.PASSWORD_DB);
        Statement statement = connection.createStatement();
        statement.executeUpdate("UPDATE role SET Role='" + role + "' WHERE id=" + id);
        ResultSet resultSet=statement.executeQuery("SELECT * FROM role WHERE id=" + id);
        System.out.print("Changed: ");
        while (resultSet.next()){
            String out=resultSet.getInt("id")+" "+resultSet.getString("Role");
            System.out.println(out);
        }
        connection.close();
    }

    public static void delete(int id) throws SQLException{
        Connection connection  = DriverManager.getConnection(ADB.URL_DB, ADB.USER_DB, ADB.PASSWORD_DB);
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM role WHERE id=" + id);
        read();
        connection.close();
    }
}
