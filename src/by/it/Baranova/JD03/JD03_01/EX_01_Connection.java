package by.it.Baranova.JD03.JD03_01;

import java.sql.Connection;
import java.sql.DriverManager;


public class EX_01_Connection {

    public static void main(String[] args){

        try (Connection connection=
                 DriverManager.getConnection
                         (CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);){

            if (!connection.isClosed()) {
                System.out.println("Соединение установлено");
            }
            connection.close();
            if (!connection.isClosed()) {
                System.out.println("Cоединение установлено");
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
