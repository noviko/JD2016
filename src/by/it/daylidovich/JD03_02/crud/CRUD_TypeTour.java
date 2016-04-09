package by.it.daylidovich.JD03_02.crud;

import by.it.daylidovich.JD03_01.ADB;

import java.sql.*;

public class CRUD_TypeTour {
    public static void read() throws SQLException {
        Connection connection  = DriverManager.getConnection(ADB.URL_DB, ADB.USER_DB, ADB.PASSWORD_DB);
        Statement statement = connection.createStatement();
        System.out.println("Table Type Tour:");
        ResultSet resultSet=statement.executeQuery("SELECT * FROM type_tour;");
        while (resultSet.next()){
            String out=resultSet.getInt("id")+" "+resultSet.getString("Type_tour");
            System.out.println(out);
        }
        connection.close();
    }

    public static void create(String tourType) throws SQLException{
        Connection connection  = DriverManager.getConnection(ADB.URL_DB, ADB.USER_DB, ADB.PASSWORD_DB);
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO type_tour(Type_tour) VALUES ('" + tourType + "')");
        ResultSet resultSet = statement.executeQuery("SELECT * FROM type_tour ORDER BY id DESC LIMIT 1");
        System.out.print("Added: ");
        while (resultSet.next()){
            String out=resultSet.getInt("id")+" "+resultSet.getString("Type_tour");
            System.out.println(out);
        }
        connection.close();
    }

    public static void update(int id, String tourType) throws SQLException{
        Connection connection  = DriverManager.getConnection(ADB.URL_DB, ADB.USER_DB, ADB.PASSWORD_DB);
        Statement statement = connection.createStatement();
        statement.executeUpdate("UPDATE type_tour SET Type_tour='" + tourType + "' WHERE id=" + id);
        ResultSet resultSet=statement.executeQuery("SELECT * FROM type_tour WHERE id=" + id);
        System.out.print("Changed: ");
        while (resultSet.next()){
            String out=resultSet.getInt("id")+" "+resultSet.getString("Type_tour");
            System.out.println(out);
        }
        connection.close();
    }

    public static void delete(int id) throws SQLException{
        Connection connection  = DriverManager.getConnection(ADB.URL_DB, ADB.USER_DB, ADB.PASSWORD_DB);
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM type_tour WHERE id=" + id);
        read();
        connection.close();
    }
}
