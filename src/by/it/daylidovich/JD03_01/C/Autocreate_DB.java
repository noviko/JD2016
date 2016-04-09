package by.it.daylidovich.JD03_01.C;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Autocreate_DB {
    public static void main(String[] args) {
        try(Connection connection  = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
        Statement statement = connection.createStatement()) {
            //создание таблицы
            CreatingUtils.createTable(statement);
            System.out.println("Tables created.");

            //добавление записей в таблицы
            CreatingUtils.insertDataToTables(statement);
            System.out.println("Row added.");

            //удаление таблицы USERS
            CreatingUtils.deleteTable(statement);
            System.out.println("Table deleted.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
