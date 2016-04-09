package by.it.daylidovich.JD03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test_Connection_With_DB {
    public static void main(String[] args) {
        try(Connection connection  = DriverManager.getConnection("jdbc:mysql://localhost:2016/it_academy","root", "")) {
            if (!connection.isClosed())
                System.out.println("Соединение установлено");
            connection.close();
            if (connection.isClosed())
                System.out.println("Соединение прервано");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
