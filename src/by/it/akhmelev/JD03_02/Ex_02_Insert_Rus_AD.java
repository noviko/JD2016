package by.it.akhmelev.JD03_02;

import by.it.Xampp;
import by.it.akhmelev.JD03_01.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Ex_02_Insert_Rus_AD {


    public static void main(String[ ] args) {
        try (Connection connection= Xampp.getConnection();
             Statement statement=connection.createStatement();) {

            //вставляем объявления
            statement.executeUpdate(
                    "INSERT INTO ad (RoomCount, Price, Area, Floor, Floors, Address, FK_Users, Description) "+
                            "VALUES (2, 65000, '42', 3, 5, 'Кнорина 18', 1, 'Хорошая квартира');"
            );
            statement.executeUpdate(
                    "INSERT INTO ad (RoomCount, Price, Area, Floor, Floors, Address, FK_Users, Description) "+
                    "VALUES (2, 85000, '42', 3, 5, 'Независимости 35', 1, 'Элитное жилье');"            );
            statement.executeUpdate(
                    "INSERT INTO ad (RoomCount, Price, Area, Floor, Floors, Address, FK_Users, Description) "+
                    "VALUES (2, 45000, '42', 1, 1, 'Мурова 5', 1, 'Доступное жилье на окраине Минска.');"            );
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
