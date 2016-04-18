package projects.telushko.servlets.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatusDAO extends DAO {
    //этот класс получает готовые данные из справочника
    Integer getID(String strStatus) throws SQLException {
        //Read
        Integer res = null;
        String sql = "SELECT ID FROM fk_status WHERE status=`" + strStatus + "`;";
        try (Connection connection = Xampp.getConnection();
             Statement statement = connection.createStatement();) {
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) res = rs.getInt("id");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    String getStatus (Integer id) throws SQLException {
        //Read
        String res = null;
        String sql = "SELECT * FROM fk_status WHERE id=" + id + ";";
        try (Connection connection = Xampp.getConnection();
             Statement statement = connection.createStatement();) {
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) res = rs.getString("status");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
