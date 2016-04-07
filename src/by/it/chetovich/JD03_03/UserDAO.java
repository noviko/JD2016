package by.it.chetovich.JD03_03;

import by.it.chetovich.JD03_02.DB_it_academy.CN;
import by.it.chetovich.JD03_02.DB_it_academy.User;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;


/**
 * UserDAO
 */
public class UserDAO extends DAO implements InterfaceDAO<User> {


    @Override
    public boolean create(User user) {
        String sql = String.format("insert into users (name, surname, login, password, birth_date, id_role, email) " +
                "values ('%s','%s','%s','%s','%s','%d','%s' );", user.getName(), user.getSurname(), user.getLogin(),
                user.getPassword(), user.getBirthdate(), user.getRole(), user.getEmail());

        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean update(User user) {
        String sql = String.format(
                "UPDATE users SET name = '%s', surname = '%s', login = '%s', password = '%s'," +
                        "birth_date = '%s', id_role = '%d', email = '%s' WHERE id = %d", user.getName(),
                user.getSurname(), user.getLogin(), user.getPassword(), user.getBirthdate(), user.getRole(), user.getEmail(),
                user.getId()

        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(User user) {
        String sql = String.format(
                "DELETE FROM users WHERE id = %d;", user.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public User read(int id) {
        HashMap<Integer,User> users = getAll("WHERE id=" + id);
        if (users.size() > 0) {
            return users.get(id);
        } else
            return null;    }

    @Override
    public HashMap<Integer, User> getAll(String where) {
        HashMap <Integer, User> users = new HashMap<>();
        String sql = "SELECT * FROM users " + where + " ;";
        try (
                Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
                Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setBirthdate(rs.getTimestamp("birth_date"));
                user.setRole(rs.getInt("id_role"));
                user.setEmail(rs.getString("email"));
                users.put(rs.getInt("id"),user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;    }

    @Override
    public void showTable() {
        HashMap<Integer, User> users = getAll("");
        System.out.println("USERS");
        for (Map.Entry<Integer, User> entry : users.entrySet()) {
            String s = "User "+entry.getKey().toString() + ": "+entry.getValue().toString();
            System.out.println(s);
        }
    }
}
