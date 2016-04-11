package projects.akhmelev.servlets.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoleDAO extends DAO {

    //этот класс получает готовые данные из справочника
    public Integer getID(String strRole) throws SQLException {
        //Read
        Integer res = null;
        String sql = "SELECT ID FROM Role WHERE Role=`" + strRole + "`;";
        try (Connection connection = Cnn.getConnection();
             Statement statement = connection.createStatement();) {
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) res = rs.getInt("ID");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public String getRole(Integer id) throws SQLException {
        //Read
        String res = null;
        String sql = "SELECT * FROM Role WHERE ID=" + id + ";";
        try (Connection connection = Cnn.getConnection();
             Statement statement = connection.createStatement();) {
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) res = rs.getString("Role");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }




}
