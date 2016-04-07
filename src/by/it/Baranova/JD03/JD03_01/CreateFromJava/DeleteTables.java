package by.it.Baranova.JD03.JD03_01.CreateFromJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DeleteTables {

    public static void main (String[] args ){

        try (Connection connection= DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB)){
            Statement stat=connection.createStatement();

            stat.executeUpdate("drop table Users");
            stat.executeUpdate("drop table Role");
            stat.executeUpdate("drop table BedSize");
            stat.executeUpdate("drop table Orders");
            stat.executeUpdate("drop table Rooms");
            stat.executeUpdate("drop table Seaview");
        } catch (SQLException e){
            e.printStackTrace();
        }

        /*
        statement.executeUpdate("ALTER TABLE Orders DROP FOREIGN KEY FKUser;");
        statement.executeUpdate("ALTER TABLE Rooms DROP FOREIGN KEY FKFirstBedSize, FKSecondBedSize, FKSeaview, FKOrderNumber;");
        statement.executeUpdate("ALTER TABLE Users DROP FOREIGN KEY FKRole, FKOrderNumber ");*/


        System.out.println("All tables from Database were deleted ");
    }
}
