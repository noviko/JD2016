package by.it.daylidovich.JD03_03;

import by.it.daylidovich.JD03_03.DAO.DAO;
import by.it.daylidovich.JD03_03.DAO.UsersDAO;
import by.it.daylidovich.JD03_03.DTO.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DAO.getDAO();

        System.out.println("Table 'Users':");
        List<User> users = new UsersDAO().getAll("");
        for (User user: users)
            System.out.println(user.toString());

        DAO.closeDAO();
    }
}
