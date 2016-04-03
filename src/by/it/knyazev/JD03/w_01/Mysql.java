package by.it.knyazev.JD03.w_01;

/**
 * Created by Mac on 03.04.16.
 */

import java.sql.*;
import java.util.regex.Pattern;

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

    public static void checkTables() throws SQLException {
        DatabaseMetaData dbmd = conn.getMetaData();
        ResultSet rs = dbmd.getTables(null, null, null, null);
        if (rs.next()) {
            System.out.println(rs.getString(3));
            String s = rs.getString(3);
            if (!s.contains("dle_post")){
                CreateTable();
            }
        }else{
            CreateTable();
        }
    }

    public static void CreateTable() throws SQLException {
        Patterns.createTfiller();
        for (int i = 0; i < Patterns.createT.size(); i++) {
            ExecuteUpdate(Patterns.createT.get(i));
        }
    }

}
