package projects.telushko.servlets.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderTypeDAO extends DAO {
    //этот класс получает готовые данные из справочника
    Integer getID(String strType) throws SQLException {
        //Read
        Integer res = null;
        String sql = "SELECT ID FROM fk_order_types WHERE order_type=`" + strType + "`;";
        try (Connection connection = Xampp.getConnection();
             Statement statement = connection.createStatement();) {
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) res = rs.getInt("id");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    String getOrderType(Integer id) throws SQLException {
        //Read
        String res = null;
        String sql = "SELECT * FROM fk_order_types WHERE id=" + id + ";";
        try (Connection connection = Xampp.getConnection();
             Statement statement = connection.createStatement();) {
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) res = rs.getString("order_type");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
