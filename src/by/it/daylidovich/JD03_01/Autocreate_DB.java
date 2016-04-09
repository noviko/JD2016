package by.it.daylidovich.JD03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Autocreate_DB {
    public static void main(String[] args) {
        try(Connection connection  = DriverManager.getConnection(ADB.URL_DB, ADB.USER_DB, ADB.PASSWORD_DB);
        Statement statement = connection.createStatement()) {
            //создание таблицы USERS
            statement.executeUpdate("CREATE TABLE users (\n" +
                    "ID INT AUTO_INCREMENT ,\n" +
                    "Name VARCHAR(15) NOT NULL ,\n" +
                    "Surname VARCHAR(25) NOT NULL ,\n" +
                    "Email VARCHAR(20) NOT NULL ,\n" +
                    "Login VARCHAR(15) NOT NULL ,\n" +
                    "Password VARCHAR(20) NOT NULL ,\n" +
                    "Role INT(2) NOT NULL,\n" +
                    "PRIMARY KEY (ID)\n" +
                    ");");
            System.out.println("Table USERS created.");

            //добавление записи в таблицу
            statement.executeUpdate("insert into users(Name, Surname, Email, Login, Password, Role)\n" +
                    "values ('Dmitry', 'Dailidovich', 'dmitry.dailidovich@gmail.com', 'Dolf23', '123', 1)");
            System.out.println("Row added.");

            //удаление таблицы USERS
            statement.executeUpdate("drop table users;");
            System.out.println("Table deleted.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
