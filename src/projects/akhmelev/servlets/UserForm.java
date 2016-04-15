package projects.akhmelev.servlets;

import projects.akhmelev.servlets.dao.RoleDAO;
import projects.akhmelev.servlets.dao.User;
import projects.akhmelev.servlets.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
        String message="Операция ";
        User user = new User();
        try {
            user.setId(Integer.parseInt(req.getParameter("ID")));
            try {
                user.setLogin(req.getParameter("Login"));
                user.setPassword(req.getParameter("Password"));
                user.setEmail(req.getParameter("Email"));
                user.setFk_Role(Integer.parseInt(req.getParameter("FK_role")));
            } catch (Exception e)
            {
                //тут лучше записать событие в лог
            }

            //bean получен. Теперь в зависимости от ID добавим обновим или удалим запись в БД.
            UserDAO userDAO = new UserDAO();
            if (0 == user.getId()) {
                message=message+" создания пользователя "+user+" ";
                ok = userDAO.create(user);
            }
            else if (0 < user.getId()) {
                message=message+" обновления данных пользователя "+user+" ";
                ok = userDAO.update(user);
            }
            else if (0 > user.getId()) {
                message=message+" удаления пользователя "+user+" ";
                user.setId(-1 * user.getId());
                ok = userDAO.delete(user);
            }

            if (!ok) throw new Exception("СБОЙ!");
            //операция завершена. Пока просто выведем в браузер результат без редиректа на заготовленную страницу
            {
                message=message.concat("успешно завершена.");
            }

        } catch (Exception e) {
            message=message.concat("<b>не выполнена</b>.<br>"+e);
        }
        //передать сообщение можно через сессию, например так:
        //
        // HttpSession session=req.getSession();
        // session.setAttribute("message",message);
        //
        //но гораздо удобнее передать сообщение через в запросе применяя forward
        req.setAttribute("message", message);
        req.getRequestDispatcher("message.jsp").forward(req,resp);
        //тогда на целевой jsp не потребуется внедрять java-код для чтения сессии
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // получаем DAO и затем читаем список пользователей
        //тут можно вытащить из req условия отбора, если это нужно
        UserDAO userDAO=new UserDAO();
        List<User> listUser=userDAO.getAll("");
        //передаем собранные данные в jsp-представление для вывода их в html-виде
        //основное тут это объект listUser - коллекция пользователей
        req.setAttribute("listUser", listUser);
        req.getRequestDispatcher("zzz-FromUserForm.jsp").forward(req,resp);
    }
}

