package by.it.Baranova.JD03.JD03_02.CRUD_Rooms;


import by.it.Baranova.JD03.JD03_02.CN;

import java.sql.*;

public class WorkingWithDatabase {

    /**
     * Reading table "Rooms" from database
     * @throws SQLException
     */
    public static void readingTable()throws SQLException {
        Connection conn;
        Statement stat;
        conn=DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);
        stat=conn.createStatement();
        System.out.println("TABLE ROOMS");
        ResultSet resultSet=stat.executeQuery("SELECT * FROM Rooms;");
        while (resultSet.next()){
            String out=resultSet.getString("RoomNumber")+" "+resultSet.getString("GuestQuantity")+" "+resultSet.getString("Price");
            System.out.println(out);
        }
        conn.close();
    }

    /**
     * Create a new row in table "Rooms" from database and reading this row
     * @throws SQLException
     */
    public static void create_read() throws SQLException{
        Connection conn;
        Statement stat;
        conn= DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);
        stat=conn.createStatement();
        stat.executeUpdate("INSERT INTO Rooms(idRooms, RoomNumber, GuestQuantity, FKFirstBedSize, FKSecondBedSize, FKSeaview, Floor, Price, FKOrderNumber)\n" +
                "VALUES (6,'R06',2,3,6,2,1,85,null)");
        ResultSet resultSet=stat.executeQuery("" +
                "SELECT * " +
                "FROM Rooms " +
                "WHERE idRooms=6");
        System.out.print("Added row: ");
        while (resultSet.next()){
            String out=resultSet.getString("RoomNumber")+" "+resultSet.getString("GuestQuantity")+" "+resultSet.getString("Price");
            System.out.println(out);
        }
        conn.close();
    }

    /**
     * Update a row in the table and reading this row
     * @throws SQLException
     */
    public static void update_read() throws SQLException{
        Connection conn;
        Statement stat;
        conn= DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);
        stat=conn.createStatement();
        stat.executeUpdate("UPDATE Rooms " +
                "SET idRooms=6,RoomNumber='R06',GuestQuantity=2,FKFirstBedSize=3,FKSecondBedSize=6,\n" +
                "FKSeaview=2,Floor=1,Price=75,FKOrderNumber=null WHERE idRooms=6");

        ResultSet resultSet=stat.executeQuery("" +
                "SELECT * " +
                "FROM Rooms " +
                "WHERE idRooms=6");
        System.out.print("Changed row: ");
        while (resultSet.next()){
            String out=resultSet.getString("RoomNumber")+" "+resultSet.getString("GuestQuantity")+" "+resultSet.getString("Price");
            System.out.println(out);
        }
        conn.close();

    }

    /**
     * Delete a row from table and read left rows
     * @throws SQLException
     */
    public static void delete_read() throws SQLException{
        Connection conn;
        Statement stat;
        conn= DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);
        stat=conn.createStatement();
        stat.executeUpdate("DELETE FROM Rooms WHERE idRooms=6");
        System.out.println("A new row was deleted");
        ResultSet resultSet=stat.executeQuery("" +
                "SELECT * " +
                "FROM Rooms ");
        System.out.println("Left rows: ");
        while (resultSet.next()){
            String out=resultSet.getString("RoomNumber")+" "+resultSet.getString("GuestQuantity")+" "+resultSet.getString("Price");
            System.out.println(out);
        }
    conn.close();
    }
}
