package by.it.Baranova.JD03.JD03_02.CRUD_Seaview;


import by.it.Baranova.JD03.JD03_02.CN;

import java.sql.*;

public class WorkingWithDatabase {

    /**
     * Reading table "Seaview" from database
     * @throws SQLException
     */
    public static void readingTable()throws SQLException {
        Connection conn;
        Statement stat;
        conn=DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);
        stat=conn.createStatement();
        System.out.println("TABLE SEAVIEW");
        ResultSet resultSet=stat.executeQuery("SELECT * FROM Seaview;");
        while (resultSet.next()){
            String out=resultSet.getString("idSeaview")+" "+resultSet.getString("Seaviewcol");
            System.out.println(out);
        }
        conn.close();
    }

    /**
     * Create new row in table "Seaview" from database and reading this row
     * @throws SQLException
     */
    public static void create_read() throws SQLException{
        Connection conn;
        Statement stat;
        conn= DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);
        stat=conn.createStatement();
        stat.executeUpdate("INSERT INTO Seaview(idSeaview, Seaviewcol) VALUES (3,'partly')");
        ResultSet resultSet=stat.executeQuery("" +
                "SELECT * " +
                "FROM Seaview " +
                "WHERE idSeaview=3");
        System.out.print("Added row: ");
        while (resultSet.next()){
            String out=resultSet.getString("idSeaview")+" "+resultSet.getString("Seaviewcol");
            System.out.println(out);
        }
        conn.close();
    }

    /**
     * Update row in the table and reading this row
     * @throws SQLException
     */
    public static void update_read() throws SQLException{
        Connection conn;
        Statement stat;
        conn= DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);
        stat=conn.createStatement();
        stat.executeUpdate("UPDATE Seaview SET idSeaview=3,Seaviewcol='a little bit' WHERE idSeaview=3");
        ResultSet resultSet=stat.executeQuery("" +
                "SELECT * " +
                "FROM Seaview " +
                "WHERE idSeaview=3");
        System.out.print("Changed row: ");
        while (resultSet.next()){
            String out=resultSet.getString("idSeaview")+" "+resultSet.getString("Seaviewcol");
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
        stat.executeUpdate("DELETE FROM Seaview WHERE idSeaview=3");
        System.out.println("A new row was deleted");
        ResultSet resultSet=stat.executeQuery("" +
                "SELECT * " +
                "FROM Seaview ");
        System.out.println("Left rows: ");
        while (resultSet.next()){
            String out=resultSet.getString("idSeaview")+" "+resultSet.getString("Seaviewcol");
            System.out.println(out);
        }
        conn.close();
    }
}
