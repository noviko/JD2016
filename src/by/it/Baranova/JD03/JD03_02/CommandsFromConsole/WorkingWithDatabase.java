package by.it.Baranova.JD03.JD03_02.CommandsFromConsole;


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
    public static void insert(String line) throws SQLException{
        Connection conn;
        Statement stat;
        conn= DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);
        stat=conn.createStatement();
        String command="INSERT INTO BedSize(BedSizecol) VALUES ('"+line+"');";
        stat.executeUpdate(command);
        System.out.println("A row was added: ");
        conn.close();
    }


    /**
     * Select a row in table "BedSize" from database and reading this row
     * @throws SQLException
     */
    public static void select(String line) throws SQLException{
        Connection conn;
        Statement stat;
        conn= DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);
        stat=conn.createStatement();
        String command="SELECT * FROM BedSize WHERE idBedSize="+line;
        ResultSet resultSet=stat.executeQuery(command);
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
    public static void update(String id,String line) throws SQLException{
        Connection conn;
        Statement stat;
        conn= DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);
        stat=conn.createStatement();
        String command="UPDATE BedSize SET idBedSize="+id+",BedSizecol='"+line+"' WHERE idBedSize="+id;
        stat.executeUpdate(command);
        System.out.print("A row was changed");
        conn.close();
    }

    /**
     * Delete a row from table and read left rows
     * @throws SQLException
     */
    public static void delete(String id) throws SQLException{
        Connection conn;
        Statement stat;
        conn= DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);
        stat=conn.createStatement();
        String command="DELETE FROM BedSize WHERE idBedSize="+id;
        stat.executeUpdate(command);
        System.out.println("A row was deleted");
        conn.close();
    }
}
