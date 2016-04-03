package by.it.knyazev.JD03.w_01;

/**
 * Created by Mac on 03.04.16.
 */

import java.sql.*;

/**
 * Created by Mac on 02.04.16.
 */
public class Mysql {

    public static Connection conn;
    public static Statement statement;

    public static void Connect() throws SQLException {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://"+Main.Mhost+"/"+Main.Mdb ,Main.Muser, Main.Mpass);
            statement = conn.createStatement();
        }catch (Exception e){
            System.out.println("MYSQL Connect ERROR: "+e.getMessage());
        }
    }

    public static void ExecuteUpdate(String query) throws SQLException {
        try {
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("MYSQL Update ERROR: "+e.getMessage());
        }
    }

    public static void CloseConnect() throws SQLException {
        try {
            statement.close();
            conn.close();
        }catch (Exception e){
            System.out.println("MYSQL Connect close ERROR: "+e.getMessage());
        }
    }

}
