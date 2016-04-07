package by.it.Baranova.JD03.JD03_01;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex_02_CN {

    public static void main(String[ ] args) {
        try (Connection connection= DriverManager.getConnection (CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);
             Statement statement=connection.createStatement();) {
                ResultSet resultSet=statement.executeQuery("select * from Users;");
                while (resultSet.next()){
                    String out=resultSet.getString("Surname")+" "+resultSet.getString("Name")+" "+resultSet.getString("FKRole");
                    System.out.println(out);
                }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
