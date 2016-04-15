package by.it.novik.JD03_01;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conn {
    public static void main(String[] args) {
        try (Connection connection =
                     DriverManager.getConnection
                             ("jdbc:mysql://localhost:2016/air?useUnicode=true&amp;characterEncoding=UTF-8", "root", "");) {
            if (!connection.isClosed())
                System.out.println("Connected");
            connection.close();
            if (connection.isClosed())
                System.out.println("Disconnected");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
