package by.it.telushko.jd03_03;


import by.it.Xampp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO extends DAO implements InterfaceDAO<Account>{
    @Override
    public List<Account> getAll(String WHERE) {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT * FROM accounts " + WHERE + " ;";
        try (
                Connection connection = Xampp.getConnection();
                Statement statement = connection.createStatement();
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Account account = new Account();
                account.setName(rs.getString("name"));
                account.setId(rs.getInt("id"));
                account.setLogin(rs.getString("login"));
                account.setEmail(rs.getString("email"));
                account.setPhone(rs.getString("phone"));
                account.setPassword(rs.getString("password"));
                account.setFk_role(rs.getInt("role"));
                accounts.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }
    @Override
    public Account read(int id) {
        List<Account> accounts = getAll("WHERE id=" + id + " LIMIT 0,1");
        if (accounts.size() > 0) {
            return accounts.get(0);

        } else
            return null;
    }
    @Override
    public boolean create(Account account) {
        String sql = String.format(
                "insert INTO accounts(name,login,password,email,phone,role)" +
                        " values('%s','%s','%s','%s','%s',%d);",
                account.getName(),account.getLogin(), account.getPassword(), account.getEmail(), account.getPhone(),account.getFk_role()
        );
        return (0 < executeUpdate(sql));
    }
    @Override
    public boolean update(Account account) {
        String sql = String.format(
                "UPDATE `accounts` SET `name`='%s',`login` = '%s', `password` = '%s', `email` = '%s',`phone`='%s', `role` = '%d' WHERE `accounts`.`id` = %d",
                account.getName(),account.getLogin(), account.getPassword(), account.getEmail(), account.getPhone(),account.getFk_role(), account.getId()
        );
        return (0 < executeUpdate(sql));
    }
    @Override
    public boolean delete(Account account) {
        String sql = String.format(
                "DELETE FROM `accounts` WHERE `accounts`.`id` = %d;", account.getId()
        );
        return (0 < executeUpdate(sql));
    }
}
