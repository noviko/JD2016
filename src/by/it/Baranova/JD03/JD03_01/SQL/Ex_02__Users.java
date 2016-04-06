package by.it.Baranova.JD03.JD03_01.SQL;

import java.sql.*;


public class Ex_02__Users {


    public static void main(String[ ] args) {
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);

             Statement statement=connection.createStatement();) {
            statement.executeUpdate(
                    "insert into Users (Login,Password,Name,Surname,Phonenumber,Mail,FKRole)"+
                    "values('poval','povale','Egor','Povalev',375295673425,'poval_e@mail.ru','2');"
            );
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
