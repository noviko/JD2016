package by.it.Baranova.JD03.JD03_03.DAO;

import by.it.Baranova.JD03.JD03_03.CN;

import java.sql.*;

public class SeaviewDAO {

    //этот класс получает готовые данные из справочника
    Integer getID(String strSeaview) throws SQLException {
        //Read
        Integer res = null;
        String sql = "SELECT idSeaview FROM Seaview WHERE Seaviewcol=" + strSeaview + ";";
        try (Connection connection = DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);
             Statement statement = connection.createStatement();) {
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) res = rs.getInt("idSeaview");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    String getSeaview(Integer id) throws SQLException {
        //Read
        String res = null;
        String sql = "SELECT * FROM Seaview WHERE idSeaview=" + id + ";";
        try (Connection connection =  DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);
             Statement statement = connection.createStatement();) {
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) res = rs.getString("Seaviewcol");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}

