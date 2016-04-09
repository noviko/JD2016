package by.it.daylidovich.JD03_02.A_crud;

import by.it.daylidovich.JD03_01.ADB;

import java.sql.*;

public class CRUD_TypeHotel {
    public static void read() throws SQLException {
        Connection connection  = DriverManager.getConnection(ADB.URL_DB, ADB.USER_DB, ADB.PASSWORD_DB);
        Statement statement = connection.createStatement();
        System.out.println("Table Type Hotel:");
        ResultSet resultSet=statement.executeQuery("SELECT * FROM type_hotel;");
        while (resultSet.next()){
            String out=resultSet.getInt("id")+" "+resultSet.getString("Type_hotel");
            System.out.println(out);
        }
        connection.close();
    }

    public static void create(String hotelType) throws SQLException{
        Connection connection  = DriverManager.getConnection(ADB.URL_DB, ADB.USER_DB, ADB.PASSWORD_DB);
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO type_hotel(Type_hotel) VALUES ('" + hotelType + "')");
        ResultSet resultSet = statement.executeQuery("SELECT * FROM type_hotel ORDER BY id DESC LIMIT 1");
        System.out.print("Added: ");
        while (resultSet.next()){
            String out=resultSet.getInt("id")+" "+resultSet.getString("Type_hotel");
            System.out.println(out);
        }
        connection.close();
    }

    public static void update(int id, String hotelType) throws SQLException{
        Connection connection  = DriverManager.getConnection(ADB.URL_DB, ADB.USER_DB, ADB.PASSWORD_DB);
        Statement statement = connection.createStatement();
        statement.executeUpdate("UPDATE type_hotel SET Type_hotel='" + hotelType + "' WHERE id=" + id);
        ResultSet resultSet=statement.executeQuery("SELECT * FROM type_hotel WHERE id=" + id);
        System.out.print("Changed: ");
        while (resultSet.next()){
            String out=resultSet.getInt("id")+" "+resultSet.getString("Type_hotel");
            System.out.println(out);
        }
        connection.close();
    }

    public static void delete(int id) throws SQLException{
        Connection connection  = DriverManager.getConnection(ADB.URL_DB, ADB.USER_DB, ADB.PASSWORD_DB);
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM type_hotel WHERE id=" + id);
        read();
        connection.close();
    }
}
