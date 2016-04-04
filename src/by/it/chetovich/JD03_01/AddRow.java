package by.it.chetovich.JD03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Add query
 */
public class AddRow {

    public static void main(String[] args) {

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/searchhost_java", CN.USER_DB, CN.PASSWORD_DB);
            Statement statement = connection.createStatement()) {
            statement.executeUpdate("insert into cities (city) value ('Barcelona');");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
