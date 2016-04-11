package projects.akhmelev.servlets;

import projects.akhmelev.servlets.dao.RoleDAO;
import projects.akhmelev.servlets.dao.User;
import projects.akhmelev.servlets.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


public class UserForm extends HttpServlet {

    public static void main(String[] args) throws SQLException {
        //это можно запустить просто для проверки. В проекте main не используется.
        //для отчетов и экспериметов используйте папку со своей фамилией.
        System.out.print(new RoleDAO().getRole(1));
        //HttpServletRequest req=new HttpServletRequest()
        User user = new User();
        user.setId(Integer.parseInt("0"));
        user.setLogin("us");
        user.setPassword("pass");
        user.setEmail("em");
        user.setFk_Role(1);
        System.out.print(user);
        UserDAO userDAO = new UserDAO();
        userDAO.create(user);
    }


    @Override
    //для производительности часто делают ОДИН сервлет на все формы, т.к. он висит в памяти все время
    //но тут будет все иначе

    //обработка формы(форм) нашего приложения по протоколу Post
    //чтобы не было путаницы лучше создать по отдельному сервлету на каждый тип форм
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //тут нужно заполнить бин, и передать его в DAO на создание, обновление, удаление
        boolean ok = false;
        PrintWriter out = resp.getWriter();
        User user = new User();
        try {

            user.setId(Integer.parseInt(req.getParameter("ID")));

            user.setLogin(req.getParameter("Login"));
            user.setPassword(req.getParameter("Password"));
            user.setEmail(req.getParameter("Email"));

            user.setFk_Role(Integer.parseInt(req.getParameter("FK_role")));

            //bean получен. Теперь в зависимости от ID добавим обновим или удалим запись в БД.
            UserDAO userDAO = new UserDAO();
            userDAO.create(user);
            if (0 == user.getId()) {
                out.println("<body>Create. <br>");
                ok = userDAO.create(user);
            }
            if (0 < user.getId()) {
                ok = userDAO.update(user);
            }
            if (0 > user.getId()) {
                user.setId(-1 * user.getId());
                ok = userDAO.delete(user);
            }
            if (!ok) throw new Exception("СБОЙ!");
            //операция завершена. Пока просто выведем в браузер результат без редиректа на заготовленную страницу
            {
                out.println("OK. <br>");
            }

        } catch (Exception e) {
            out.println("Error. <br>");
        }
        out.print(user.toString());
        out.flush();
    }
}

