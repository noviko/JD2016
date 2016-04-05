package by.it.Baranova.JD03.JD03_02.CRUD_BedSize;


import by.it.Baranova.JD03.JD03_02.CN;

import java.sql.*;

public class WorkingWithDatabase {

    /**
     * Reading table "BedSize" from database
     * @throws SQLException
     */
    public static void readingTable()throws SQLException {
        Connection conn;
        Statement stat;
        conn=DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);
        stat=conn.createStatement();
        System.out.println("TABLE BedSize");
        ResultSet resultSet=stat.executeQuery("SELECT * FROM BedSize;");
        while (resultSet.next()){
            String out=resultSet.getString("idBedSize")+" "+resultSet.getString("BedSizecol");
            System.out.println(out);
        }
        conn.close();
    }

    /**
     * Create new row in table "BedSize" from database and reading this row
     * @throws SQLException
     */
    public static void create_read() throws SQLException{
        Connection conn;
        Statement stat;
        conn= DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);
        stat=conn.createStatement();
        stat.executeUpdate("INSERT INTO BedSize(idBedSize, BedSizecol) VALUES (7,'California king')");
        ResultSet resultSet=stat.executeQuery("" +
                "SELECT * " +
                "FROM BedSize " +
                "WHERE idBedSize=7");
        System.out.print("Added row: ");
        while (resultSet.next()){
            String out=resultSet.getString("idBedSize")+" "+resultSet.getString("BedSizecol");
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
        stat.executeUpdate("UPDATE BedSize SET idBedSize=7,BedSizecol='California queen' WHERE idBedSize=7");
        ResultSet resultSet=stat.executeQuery("" +
                "SELECT * " +
                "FROM BedSize " +
                "WHERE idBedSize=7");
        System.out.print("Changed row: ");
        while (resultSet.next()){
            String out=resultSet.getString("idBedSize")+" "+resultSet.getString("BedSizecol");
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
        stat.executeUpdate("DELETE FROM BedSize WHERE idBedSize=7");
        System.out.println("A new row was deleted");
        ResultSet resultSet=stat.executeQuery("" +
                "SELECT * " +
                "FROM BedSIze ");
        System.out.println("Left rows: ");
        while (resultSet.next()){
            String out=resultSet.getString("idBedSize")+" "+resultSet.getString("BedSizecol");
            System.out.println(out);
        }
        conn.close();
    }
}
