package by.it.akhmelev.JD03_02;

import by.it.Xampp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Ex_01__Rus_Users {


    public static void main(String[ ] args) {
        try (Connection connection=Xampp.getConnection();
             Statement statement=connection.createStatement();) {
            //вставляем пользователей
            statement.executeUpdate(
                    "insert into users(Login,Password,Email,Role)"+
                            " values('проверка','админ3','admin3@tut.by','Администратор');"
            );
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
