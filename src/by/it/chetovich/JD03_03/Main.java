package by.it.chetovich.JD03_03;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {

        UserDAO userDAO = new UserDAO();
        RoleDAO roleDAO = new RoleDAO();
        userDAO.showTable();
    }
}
