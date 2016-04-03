package by.it.akhmelev.JD03_01;

import java.sql.Connection;
import java.sql.DriverManager;

public class Ex_01_Connection {


    public static void main(String[ ] args) {
            //устаревший способ регистрации. Сейчас уже не требуется.
            //Driver driver=new FabricMySQLDriver();
            //DriverManager.registerDriver(driver);
            try (Connection connection=
                         DriverManager.getConnection
                                 ("jdbc:mysql://localhost:8889/java","root", "root");) {
                if (!connection.isClosed())
                    System.out.println("Соединение установлено");
                connection.close();
                if (connection.isClosed())
                    System.out.println("Соединение прервано");
            }
            catch (Exception e){
                e.printStackTrace();
            }

    }
}
