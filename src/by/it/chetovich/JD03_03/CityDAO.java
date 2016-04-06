package by.it.chetovich.JD03_03;



import java.sql.SQLException;


/**
 * City DAO
 */
public class CityDAO extends DAO {

    public  Integer getId (String city) throws SQLException {

        Integer res = null;
        String sql = "SELECT id_city FROM cities WHERE city=`" + city + "`;";
        return executeQuery(sql, res);
    }

    public  String getCity (Integer id) throws SQLException{

        String res = null;
        String sql = "SELECT * FROM cities WHERE id_city=" + id + ";";
        return executeQuery(sql, res);
    }


}
