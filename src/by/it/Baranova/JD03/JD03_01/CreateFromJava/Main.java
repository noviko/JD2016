package by.it.Baranova.JD03.JD03_01.CreateFromJava;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        try (Connection connection= DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB)){
            Statement stat=connection.createStatement();
            CreationTables.createTables(stat);
            CreationTables.fillingTables(stat);

        } catch (SQLException e){
            e.printStackTrace();
        }

    }

}
