package by.it.Baranova.JD03.JD03_03.DAO;

import by.it.Baranova.JD03.JD03_03.CN;

import java.sql.*;

public class RoleDAO {
    //этот класс получает готовые данные из справочника
    Integer getID(String strRole) throws SQLException {
        //Read
        Integer res = null;
        String sql = "SELECT idRole FROM Role WHERE Rolecol=" + strRole + ";";
        try (Connection connection = DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);
             Statement statement = connection.createStatement();) {
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) res = rs.getInt("idRole");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    String getRole(Integer id) throws SQLException {
        //Read
        String res = null;
        String sql = "SELECT * FROM Role WHERE idRole=" + id + ";";
        try (Connection connection =  DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);
             Statement statement = connection.createStatement();) {
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) res = rs.getString("Rolecol");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}

