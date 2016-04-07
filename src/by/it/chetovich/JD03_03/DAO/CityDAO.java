package by.it.chetovich.JD03_03.DAO;



import by.it.chetovich.JD03_02.DB_it_academy.CN;

import java.sql.*;


/**
 * City DAO
 */
public class CityDAO extends DAO {

    public  Integer getId (String city) throws SQLException {

        Integer res = null;
        String sql = "SELECT * FROM cities WHERE city=`" + city + "`;";
        /*try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {*/
        Statement statement = DAO.getStatement();
        ResultSet rs = statement.executeQuery(sql);
            if (rs.next()){
                res = rs.getInt("id_city");
            }
        /*} catch (Exception e) {
            e.printStackTrace();
        }*/
        return res;
    }

    public  String getCity (Integer id) throws SQLException{

        String res = null;
        String sql = "SELECT * FROM cities WHERE id_city=" + id + ";";
        /*try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {*/
        Statement statement = DAO.getStatement();
        ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) res = rs.getString("city");
        /*} catch (Exception e) {
            e.printStackTrace();
        }*/
        return res;
    }


}
