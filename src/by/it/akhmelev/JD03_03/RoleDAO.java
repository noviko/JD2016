package by.it.akhmelev.JD03_03;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDAO extends AbstractDAO{
    //этот класс только получает готовые данные из справочника
    //поэтому нет соответствующей сущности. И поэтому методы статические.
    static Integer getID(String strRole) throws SQLException {
        ResultSet resultSet=executeQuery("SELECT ID FROM Role WHELE Role=`"+strRole+"`");
        if (resultSet.next()) {
            return resultSet.getInt("ID");
        }
        else
            return null;
    }

    static String getRole(int id) throws SQLException {
        ResultSet resultSet=executeQuery("SELECT Role FROM Role WHELE ID=`"+id+"`");
        if (resultSet.next()) {
            return resultSet.getString("Role");
        }
        else
            return null;
    }



}
