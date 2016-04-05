package by.it.Baranova.JD03.JD03_01.SQL.CreateFromJava;

import java.sql.*;

public class CreateDB {

    public static void main(String[] args){

        try (Connection connection=
                     DriverManager.getConnection
                             (("jdbc:mysql://localhost/?user=root&password=root"));){
            Statement statement=connection.createStatement();
           // int count=statement.executeUpdate("create t HotelJava");
            System.out.println("Schema 'HotelJava' created");
            connection.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
