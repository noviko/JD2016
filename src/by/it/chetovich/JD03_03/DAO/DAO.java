package by.it.chetovich.JD03_03.DAO;

import by.it.chetovich.JD03_02.DB_it_academy.CN;

import java.sql.*;
import java.util.HashMap;

/**
 * Dao
 */
public class DAO<T> {

    private static Connection connection;
    private static Statement statement;
    private static DAO dao;

    public DAO() {
        try {
            connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static Statement getStatement() {
        return statement;
    }

    static DAO getDAO() {
        if (dao == null) {
            dao = new DAO();
        }
        return dao;
    }

    static void closeDAO() {
        dao = null;
    }

    static int executeUpdate(String sql) throws SQLException {

        int result = -1;
        /*try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {*/
            Statement statement = DAO.getStatement();
            result = statement.executeUpdate(sql);
        /*} catch (Exception e) {
            e.printStackTrace();
        }*/
        return result;
    }




}
