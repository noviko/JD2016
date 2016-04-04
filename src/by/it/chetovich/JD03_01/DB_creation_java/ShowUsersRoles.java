package by.it.chetovich.JD03_01.DB_creation_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * showing users and their roles
 */
public class ShowUsersRoles {

    public static void main(String[] args) {

        try(Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
            Statement statement = connection.createStatement()) {
            QueriesForDB_Creation.showTables(statement);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
