package by.it.Baranova.JD03.JD03_02;

import java.sql.*;


public class PrintUsers {

    public static void printUsers() throws SQLException{
        Connection conn;
        Statement stat;
        conn= DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);
        stat=conn.createStatement();
        System.out.println("TABLE USERS");
        ResultSet resultSet=stat.executeQuery("SELECT Users.*,Role.* FROM Users,Role WHERE FKRole=idRole;");
        int count=0;
        while (resultSet.next()){
            count++;
            String out=resultSet.getString("Login")+" "+resultSet.getString("Name")+" "+resultSet.getString("Surname")+" "+resultSet.getString("Rolecol");
            System.out.println(out);
        }
        System.out.println("Number of Users: "+count);
        conn.close();
    }
}
