package by.it.Baranova.JD03.JD03_02.CRUD_Orders;


import by.it.Baranova.JD03.JD03_02.CN;

import java.sql.*;

public class WorkingWithDatabase {

    /**
     * Reading table "Orders" from database
     * @throws SQLException
     */
    public static void readingTable()throws SQLException {
        Connection conn;
        Statement stat;
        conn=DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);
        stat=conn.createStatement();
        System.out.println("TABLE ORDERS");
        ResultSet resultSet=stat.executeQuery("SELECT * FROM Orders;");
        while (resultSet.next()){
            String out=resultSet.getString("idOrder")+" "+resultSet.getString("FKUser")+" "+resultSet.getString("DaysQuantity")+
                    " "+resultSet.getString("FKReservedRoom");
            System.out.println(out);
        }
        conn.close();
    }

    /**
     * Create new row in table "Orders" from database and reading this row
     * @throws SQLException
     */
    public static void create_read() throws SQLException{
        Connection conn;
        Statement stat;
        conn= DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);
        stat=conn.createStatement();
        stat.executeUpdate("INSERT INTO Orders(idOrder, FKUser, DaysQuantity, GuestQuantity, FKReservedRoom)\n" +
                "VALUES (2,3,4,2,5)");
        ResultSet resultSet=stat.executeQuery("" +
                "SELECT * " +
                "FROM Orders " +
                "WHERE idOrder=2");
        System.out.print("Added row: ");
        while (resultSet.next()){
            String out=resultSet.getString("idOrder")+" "+resultSet.getString("FKUser")+" "+resultSet.getString("DaysQuantity")+
                    " "+resultSet.getString("FKReservedRoom");
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
        stat.executeUpdate("UPDATE Orders SET idOrder=2,FKUser=3,DaysQuantity=5,GuestQuantity=2,FKReservedRoom=5\n" +
                "    WHERE idOrder=2");
        ResultSet resultSet=stat.executeQuery("" +
                "SELECT * " +
                "FROM Orders " +
                "WHERE idOrder=2");
        System.out.print("Changed row: ");
        while (resultSet.next()){
            String out=resultSet.getString("idOrder")+" "+resultSet.getString("FKUser")+" "+resultSet.getString("DaysQuantity")+
                    " "+resultSet.getString("FKReservedRoom");
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
        stat.executeUpdate("DELETE FROM Orders WHERE idOrder=1");
        System.out.println("A new row was deleted");
        ResultSet resultSet=stat.executeQuery("" +
                "SELECT * " +
                "FROM Orders ");
        System.out.println("Left rows: ");
        while (resultSet.next()){
            String out=resultSet.getString("idOrder")+" "+resultSet.getString("FKUser")+" "+resultSet.getString("DaysQuantity")+
                    " "+resultSet.getString("FKReservedRoom");
            System.out.println(out);
        }
        conn.close();
    }
}
