package by.it.chetovich.JD03_03;

import by.it.chetovich.JD03_02.DB_it_academy.CN;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Dao
 */
public class DAO {

    static int executeUpdate(String sql) {
        //System.out.println("--- SQL="+sql); //отладка
        int result = -1;
        try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement();) {
            result = statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
