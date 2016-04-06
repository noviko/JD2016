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
                "PRIMARY KEY (idUsers));"
                //"FOREIGN KEY (FKRole) REFERENCES Role(idRole) ON DELETE CASCADE);"
        );

        statement.executeUpdate("CREATE TABLE HotelJava.Orders (\n" +
                "idOrder INT NOT NULL AUTO_INCREMENT," +
                "FKUser INT(11)," +
                "DaysQuantity INT(11)," +
                "GuestQuantity INT(11)," +
                "FKReservedRoom INT(11)," +
                "PRIMARY KEY (idOrder));"
                //"FOREIGN KEY (FKUser) REFERENCES Users(idUsers) ON DELETE CASCADE);"
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
                "PRIMARY KEY (idRooms));"
                //"FOREIGN KEY (FKFirstBedSize) REFERENCES BedSize(idBedSize) ON DELETE CASCADE," +
                //"FOREIGN KEY (FKSecondBedSize) REFERENCES BedSize(idBedSize) ON DELETE CASCADE," +
                //"FOREIGN KEY (FKSeaview) REFERENCES Seaview(idSeaview) ON DELETE CASCADE);"
        );

        /*statement.executeUpdate("ALTER TABLE Users " +
                "ADD FOREIGN KEY (FKOrderNumber)" +
                "REFERENCES Orders(idOrder)" +
                "ON DELETE CASCADE;"
        );

        statement.executeUpdate("ALTER TABLE Orders " +
                "ADD FOREIGN KEY (FKReservedRoom)" +
                "REFERENCES Rooms(idRooms)" +
                "ON DELETE CASCADE;"
        );*/
        System.out.println("Tables for Database were created");

    }

    public static void fillingTables(Statement statement) throws SQLException {

        //BedSize
        statement.executeUpdate("INSERT INTO BedSize(idBedSize, BedSizecol) VALUES (1,'Twin')");
        statement.executeUpdate("INSERT INTO BedSize(idBedSize, BedSizecol) VALUES (2,'Double')");
        statement.executeUpdate("INSERT INTO BedSize(idBedSize, BedSizecol) VALUES (3,'Queen')");

        //Role
        statement.executeUpdate("INSERT INTO Role(idRole, Rolecol) VALUES (1,'Manager')");
        statement.executeUpdate("INSERT INTO Role(idRole, Rolecol) VALUES (2,'Customer')");

        //Users
        statement.executeUpdate("INSERT INTO Users (idUsers, Login, Password, Name, Surname, Phonenumber, Mail, FKRole, FKOrderNumber)\n"+
                "VALUES (2,'Antonova','678h','Alina','Antonova','6745634','al_anton@icloud.com',2,null)");
        statement.executeUpdate("INSERT INTO Users (idUsers, Login, Password, Name, Surname, Phonenumber, Mail, FKRole, FKOrderNumber)\n"+
                "VALUES (1,'Ben','benny','Ben','Afflec','6745634','benny@icloud.com',2,null)");

        //Orders
        statement.executeUpdate("INSERT INTO Orders(idOrder, FKUser, DaysQuantity, GuestQuantity, FKReservedRoom)\n" +
                "VALUES (1,2,5,2,null)");
        statement.executeUpdate("INSERT INTO Orders(idOrder, FKUser, DaysQuantity, GuestQuantity, FKReservedRoom)\n" +
                "VALUES (2,2,7,4,null)");
        statement.executeUpdate("INSERT INTO Orders(idOrder, FKUser, DaysQuantity, GuestQuantity, FKReservedRoom)\n" +
                "VALUES (3,1,10,1,null)");

        //Seaview
        statement.executeUpdate("INSERT INTO Seaview(idSeaview, Seaviewcol) VALUES (3,'partly')");
        statement.executeUpdate("INSERT INTO Seaview(idSeaview, Seaviewcol) VALUES (1,'yes')");
        statement.executeUpdate("INSERT INTO Seaview(idSeaview, Seaviewcol) VALUES (2,'no')");

        //Rooms
        statement.executeUpdate("INSERT INTO Rooms(idRooms, RoomNumber, GuestQuantity, FKFirstBedSize, FKSecondBedSize, FKSeaview, Floor, Price, FKOrderNumber)\n" +
                "VALUES (1,'R01',2,1,1,2,1,85,null)");
        statement.executeUpdate("INSERT INTO Rooms(idRooms, RoomNumber, GuestQuantity, FKFirstBedSize, FKSecondBedSize, FKSeaview, Floor, Price, FKOrderNumber)\n" +
                "VALUES (2,'R02',3,2,1,2,1,95,null)");
        statement.executeUpdate("INSERT INTO Rooms(idRooms, RoomNumber, GuestQuantity, FKFirstBedSize, FKSecondBedSize, FKSeaview, Floor, Price, FKOrderNumber)\n" +
                "VALUES (3,'R03',4,3,3,2,1,105,null)");
        statement.executeUpdate("INSERT INTO Rooms(idRooms, RoomNumber, GuestQuantity, FKFirstBedSize, FKSecondBedSize, FKSeaview, Floor, Price, FKOrderNumber)\n" +
                "VALUES (4,'R04',2,1,1,2,1,85,null)");





        System.out.println("Tables of Database were filled");
    }
}