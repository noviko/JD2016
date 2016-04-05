package by.it.Baranova.JD03.JD03_02.CRUD_Seaview;


import by.it.Baranova.JD03.JD03_02.CN;

import java.sql.*;

public class Reading {

    public static void readingTable()throws SQLException {
        Connection conn;
        Statement stat;
        conn=DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);
        stat=conn.createStatement();
        ResultSet resultSet=stat.executeQuery("SELECT * FROM Seaview;");
        while (resultSet.next()){
            String out=resultSet.getString("idSeaview")+" "+resultSet.getString("Seaviewcol");
            System.out.println(out);
        }
    }
}
