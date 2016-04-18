package projects.telushko.servlets.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FeedbackDAO extends DAO {
    //этот класс получает готовые данные из справочника
    Integer getID(String strFeedback) throws SQLException {
        //Read
        Integer res = null;
        String sql = "SELECT ID FROM fk_feedback WHERE feedback=`" + strFeedback + "`;";
        try (Connection connection = Xampp.getConnection();
             Statement statement = connection.createStatement();) {
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) res = rs.getInt("id");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    String getFeedback(Integer id) throws SQLException {
        //Read
        String res = null;
        String sql = "SELECT * FROM fk_roles WHERE id=" + id + ";";
        try (Connection connection = Xampp.getConnection();
             Statement statement = connection.createStatement();) {
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) res = rs.getString("Role");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
