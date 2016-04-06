package by.it.chetovich.JD03_03;

import by.it.chetovich.JD03_02.DB_it_academy.CN;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

/**
 * Dao
 */
public class DAO<T> {

    static int executeUpdate(String sql) {
        //System.out.println("--- SQL="+sql); //отладка
        int result = -1;
        try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            result = statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //методы только для справочников, где первая колонка id, вторая - её значение
    //прегруженный метод, возвращает int
    static int executeQuery(String sql, Integer res) {
        try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) res = rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    //прегруженный метод, возвращает String
    static String executeQuery(String sql, String res) {
        try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) res = rs.getString(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }


}
