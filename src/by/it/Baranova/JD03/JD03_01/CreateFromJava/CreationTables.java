package by.it.Baranova.JD03.JD03_01.CreateFromJava;

import java.sql.*;


public class CreationTables {

    public static void createTables(Statement statement) throws SQLException {

       statement.executeUpdate("CREATE TABLE HotelJava.Role (\n"+
                "idRole INT NOT NULL,"+
                "Rolecol VARCHAR(45) NULL,"+
                "PRIMARY KEY (idRole));"
       );

        statement.executeUpdate("CREATE TABLE HotelJava.BedSize (\n" +
                "idBedSize INT NOT NULL AUTO_INCREMENT," +
                "BedSizecol VARCHAR(45)," +
                "PRIMARY KEY (idBedSize));"
        );

        statement.executeUpdate("CREATE TABLE HotelJava.Seaview (\n" +
                "idSeaview INT NOT NULL AUTO_INCREMENT," +
                "Seaviewcol VARCHAR(45)," +
                "PRIMARY KEY (idSeaview));"
        );
        statement.executeUpdate("CREATE TABLE HotelJava.Users (\n" +
                "idUsers INT NOT NULL AUTO_INCREMENT," +
                "Login VARCHAR(45)," +
                "Password VARCHAR(45)," +
                "Name VARCHAR(45)," +
                "Surname VARCHAR(45)," +
                "Phonenumber VARCHAR(45)," +
                "Mail VARCHAR(45)," +
                "FKRole INT(11)," +
                "FKOrderNumber INT(11)," +
                "PRIMARY KEY (idUsers)," +
                "FOREIGN KEY (FKRole) REFERENCES Role(idRole));"
        );

        statement.executeUpdate("CREATE TABLE HotelJava.Orders (\n" +
                "idOrder INT NOT NULL AUTO_INCREMENT," +
                "FKUser INT(11)," +
                "DaysQuantity INT(11)," +
                "GuestQuantity INT(11)," +
                "FKReservedRoom INT(11)," +
                "PRIMARY KEY (idOrder)," +
                "FOREIGN KEY (FKUser) REFERENCES Users(idUsers));"
        );

        statement.executeUpdate("CREATE TABLE HotelJava.Rooms (\n" +
                "idRooms INT NOT NULL AUTO_INCREMENT," +
                "RoomNumber VARCHAR(45)," +
                "GuestQuantity INT(11)," +
                "FKFirstBedSize INT(11)," +
                "FKSecondBedSize INT(11)," +
                "FKSeaview INT(11)," +
                "Floor INT(11)," +
                "Price INT(11)," +
                "FKOrderNumber INT(11)," +
                "PRIMARY KEY (idRooms)," +
                "FOREIGN KEY (FKFirstBedSize) REFERENCES BedSize(idBedSize)," +
                "FOREIGN KEY (FKSecondBedSize) REFERENCES BedSize(idBedSize)," +
                "FOREIGN KEY (FKSeaview) REFERENCES Seaview(idSeaview)," +
                "FOREIGN KEY (FKOrderNumber) REFERENCES Orders(idOrder));"
        );

        statement.executeUpdate("ALTER TABLE Users " +
                "ADD FOREIGN KEY (FKOrderNumber)" +
                "REFERENCES Orders(idOrder);"
        );

        statement.executeUpdate("ALTER TABLE Orders " +
                "ADD FOREIGN KEY (FKReservedRoom)" +
                "REFERENCES Rooms(idRooms);"
        );

    }

    public static void fillingTables(Statement statement) throws SQLException {


    }
}