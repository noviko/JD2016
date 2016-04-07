package by.it.Baranova.JD03.JD03_02.CRUD_Users;


import by.it.Baranova.JD03.JD03_02.CN;

import java.sql.*;

public class WorkingWithDatabase {

    /**
     * Reading table "Users" from database
     * @throws SQLException
     */
    public static void readingTable()throws SQLException {
        Connection conn;
        Statement stat;
        conn=DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);
        stat=conn.createStatement();
        System.out.println("TABLE USERS");
        ResultSet resultSet=stat.executeQuery("SELECT * FROM Users;");
        while (resultSet.next()){
            String out=resultSet.getString("Login")+" "+resultSet.getString("Name")+" "+resultSet.getString("Surname")+" "+resultSet.getString("FKRole");
            System.out.println(out);
        }
        conn.close();
    }

    /**
     * Create a new row in table "Users" from database and reading this row
     * @throws SQLException
     */
    public static void create_read() throws SQLException{
        Connection conn;
        Statement stat;
        conn= DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);
        stat=conn.createStatement();
        stat.executeUpdate("INSERT INTO Users (idUsers, Login, Password, Name, Surname, Phonenumber, Mail, FKRole, FKOrderNumber)\n"+
               "VALUES (4,'Antonova','678h','Alina','Antonova','6745634','al_anton@icloud.com',2,null)");
        ResultSet resultSet=stat.executeQuery("" +
                "SELECT * " +
                "FROM Users " +
                "WHERE idUsers=4");
        System.out.print("Added row: ");
        while (resultSet.next()){
            String out=resultSet.getString("Login")+" "+resultSet.getString("Name")+" "+resultSet.getString("Surname")+" "+resultSet.getString("FKRole");
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
        stat.executeUpdate("UPDATE Users " +
                "SET idUsers=4,Login='Antonova',Password='678h',Name='Alina',\n" +
                "Surname='Bobrova',Phonenumber='6745634',Mail='al_anton@icloud.com',FKRole=2,FKOrderNumber=2 WHERE idUsers=4");

        ResultSet resultSet=stat.executeQuery("" +
                "SELECT * " +
                "FROM Users " +
                "WHERE idUsers=4");
        System.out.print("Changed row: ");
        while (resultSet.next()){
            String out=resultSet.getString("Login")+" "+resultSet.getString("Name")+" "+resultSet.getString("Surname")+" "+resultSet.getString("FKRole");
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
        stat.executeUpdate("DELETE FROM Users WHERE idUsers=4");
        System.out.println("A new row was deleted");
        ResultSet resultSet=stat.executeQuery("" +
                "SELECT * " +
                "FROM Users ");
        System.out.println("Left rows: ");
        while (resultSet.next()){
            String out=resultSet.getString("Login")+" "+resultSet.getString("Name")+" "+resultSet.getString("Surname")+" "+resultSet.getString("FKRole");
            System.out.println(out);
        }
    conn.close();
    }
}
