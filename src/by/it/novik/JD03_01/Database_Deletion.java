package by.it.novik.JD03_01;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database_Deletion {
    public static void main(String[] args) {

        try (Connection connection =
                DriverManager.getConnection
                        ("jdbc:mysql://localhost:2016/air?useUnicode=true&amp;characterEncoding=UTF-8", "root", "");

        Statement statement = connection.createStatement()) {
        Queries.deleteATable(statement);
    }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
