package by.it.novik.JD03_01;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Qualification_select {
    public static void main(String[] args) {
        try (Connection connection =
                     DriverManager.getConnection
                             ("jdbc:mysql://localhost:2016/air?useUnicode=true&amp;characterEncoding=UTF-8", "root", "");
             Statement statement=connection.createStatement()) {
        ResultSet resultSet = statement.executeQuery("select * from qualifications;");
        while (resultSet.next()){
            String out = resultSet.getString("Qualification");
            System.out.println(out);
        }
    }
        catch (Exception e){
        e.printStackTrace();
        }
    }
}
