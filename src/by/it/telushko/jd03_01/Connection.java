package by.it.telushko.jd03_01;

import java.sql.DriverManager;

public class Connection {
    public static void main(String []args){
        try (java.sql.Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB)) {
            if (!connection.isClosed())
                System.out.println("Соединение установлено");

            Fill_db.fill_db();


            connection.close();
            if (connection.isClosed())
                System.out.println("Соединение прервано");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
