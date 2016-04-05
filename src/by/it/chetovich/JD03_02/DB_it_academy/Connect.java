package by.it.chetovich.JD03_02.DB_it_academy;

import by.it.chetovich.JD03_01.DB_creation_java.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Connection for DB it-academy
 */
public class Connect {

    public static int ConnectionExecuteUpdate (String sql){

        int rows = 0;
        try(Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
            Statement statement = connection.createStatement()) {
            rows = statement.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    public static ResultSet ConnectionExecuteQuery (String sql) {

        ResultSet resultSet = null;
        try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
