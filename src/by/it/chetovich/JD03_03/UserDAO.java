package by.it.chetovich.JD03_03;

import by.it.chetovich.JD03_02.DB_it_academy.User;

import java.util.HashMap;

/**
 * UserDAO
 */
public class UserDAO extends DAO implements InterfaceDAO<User> {


    @Override
    public boolean create(User user) {
        String sql = String.format("insert into users (name, surname, login, password, birth_date, id_role, email) " +
                "values ('%s','%s','%s','%s','%s','%d','%s' );", user.getName(), user.getSurname(), user.getLogin(),
                user.getPassword(), user.getBirthdate(), user.getId(), user.getEmail());

        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean update(User user) {
        String sql = String.format(
                "UPDATE `users` SET `name` = '%s', `surname` = '%s', `login` = '%s', `password` = '%s'," +
                        "'birth_date' = '%d', 'id_role' = '%d', 'email' = '%s' WHERE `id` = %d",
                
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public User read(int id) {
        return null;
    }

    @Override
    public HashMap<Integer, User> getAll(String where) {
        return null;
    }


}
