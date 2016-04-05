package by.it.akhmelev.JD03_03;

import by.it.akhmelev.JD03_01.CN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

abstract class AbstractDAO {
    //Create Update Delete
    static int executeUpdate(String sql) {
        int result = -1;
        try (Connection connection =
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement();) {
            result = statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //Read
    static ResultSet executeQuery(String sql) {
        ResultSet result = null;
        try (Connection connection =
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);

             Statement statement = connection.createStatement();) {
            result = statement.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}

