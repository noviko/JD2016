package by.it.akhmelev.JD03_03;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

class UserDAO extends AbstractDAO implements InterfaceDAO<User> {
    private static UserDAO dao; //синглтон для DAO

    static UserDAO getDAO() {   //метод, который создает DAO или возвращает существующий экземпляр
        if (dao == null) {
            dao = new UserDAO();
        }
        return dao;
    }

    private String sqlCreate(User user) {
        return String.format(
                "insert INTO users(Login,Password,Email,FK_Role)" +
                        " values('%s','%s','%s',%d);",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getFk_Role()
        );
    }

    private String sqlUpdate(User user) {
        return String.format(
                "update users SET `Login`=`%s`,`Password`=`%s`,`Email`=%s,FK_Role=%d)" +
                        " values('%s','%s','%s',%d) WHERE ID=%d;",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getFk_Role(), user.getId()
        );
    }

    private String sqlDelete(User user) {
        return String.format(
                "DELETE FROM users WHERE ID=%d';", user.getId()
        );
    }

    @Override
    public boolean set(User user) {
        String sql;
        int id = user.getId();
        if (0 == id) {
            sql = sqlCreate(user);
        }
        else if (0<id) {
            sql=sqlUpdate(user);
        }
        else {
            user.setId(-1*user.getId());
            sql=sqlDelete(user);
        }
        return 0<executeUpdate(sql);
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getWhere(String expression) throws SQLException {
        ResultSet rs=executeQuery("SELECT * FROM users WHERE ("+expression+");");
        if (rs.next()) {
        User user=new User();
        user.setLogin(rs.getString("login"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setFk_Role(rs.getInt("FK_Role"));
        return user;}
        else return null;
    }
}
