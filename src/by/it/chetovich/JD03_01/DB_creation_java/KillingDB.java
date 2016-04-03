package by.it.chetovich.JD03_01.DB_creation_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Kill DB
 */
public class KillingDB {

    public static void main(String[] args) {

        try(Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
            Statement statement = connection.createStatement()) {

            statement.executeUpdate("drop table feedbacks;");
            statement.executeUpdate("drop table profiles;");
            statement.executeUpdate("drop table cities;");
            statement.executeUpdate("drop table users;");
            statement.executeUpdate("drop table role;");
            //statement.executeUpdate("drop database searchhost_java;");

            System.out.println("Tables from DB searchhost_java were deleted");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
