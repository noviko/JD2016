package by.it.chetovich.JD03_03;

import by.it.chetovich.JD03_02.DB_it_academy.User;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {

        UserDAO userDAO = new UserDAO();
        userDAO.showTable();

        //добавляем пользователя и выводим его
        User user = new User("Anna","Drake","drake","yultos", new Timestamp(630720000000l),1,"drake@gmail.com");
        if (userDAO.create(user)) System.out.println("Пользователь добавлен.");
        System.out.println(user);

        //обновляем пользователя и выводим
        user = userDAO.getAll("where id = 5").get(5);
        user.setSurname("Marshall");
        if (userDAO.update(user)) System.out.println("Пользователь обновлен.");
        System.out.println(userDAO.read(5));

        //удаление ользователя и вывод оставшихся
        if (userDAO.delete(user)) System.out.println("Пользователь удалён");
        userDAO.showTable();

    }
}
