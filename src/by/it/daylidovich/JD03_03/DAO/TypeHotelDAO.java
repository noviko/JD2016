package by.it.daylidovich.JD03_03.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeHotelDAO {
    public static Integer getID(String typeHotel) throws SQLException {
        Integer out = null;
        String sql = String.format("SELECT ID FROM type_hotel_d WHERE Type_hotel='%s';", typeHotel);
        ResultSet resultSet = DAO.getStatement().executeQuery(sql);
        if (resultSet.next()) out = resultSet.getInt("id");
        return out;
    }

    public static String getTypeHotel(Integer id) throws SQLException {
        String out = null;
        String sql = String.format("SELECT * FROM type_hotel_d WHERE ID='%d';", id);
        ResultSet resultSet = DAO.getStatement().executeQuery(sql);
        if (resultSet.next()) out = resultSet.getString("Type_hotel");
        return out;
    }
}
