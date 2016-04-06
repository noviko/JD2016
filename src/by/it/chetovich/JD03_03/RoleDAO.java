package by.it.chetovich.JD03_03;

import java.sql.SQLException;

/**
 * Role DAO
 */
public class RoleDAO extends DAO {

    public  Integer getId (String role) throws SQLException{

        Integer res = null;
        String sql = "SELECT id FROM role WHERE role=`" + role + "`;";
        return executeQuery(sql, res);
    }

    public  String getRole (Integer id) throws SQLException{

        String res = null;
        String sql = "SELECT * FROM role WHERE id_role=" + id + ";";
        return executeQuery(sql, res);
    }
}
