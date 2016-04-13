package projects.chatovich.servlets;

import projects.chatovich.servlets.DAO.UserDAO;
import projects.chatovich.servlets.JD03_02.DB_it_academy.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class login extends HttpServlet {

    /*public static void main(String[] args) {

        HashMap<Integer, User> users = null;
        UserDAO userDAO = new UserDAO();
        try {
            System.out.println("inside");
            users = userDAO.getAll("where login = 'yultos' and password = 'yultos';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Map.Entry<Integer, User> entry : users.entrySet()) {
            System.out.println(entry);
        }
    }
*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //resp.setContentType("text/html");
        //resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        HashMap<Integer, User> users = null;
        UserDAO userDAO = new UserDAO();
        try {

            users = userDAO.getAll("where login = '"+login+"' and password = '"+password+"';");
            /*for (Map.Entry<Integer, User> entry : users.entrySet()) {
                out.println(entry.getKey());
            }*/

        } catch (SQLException e) {
            e.printStackTrace();
        }
        HttpSession session = req.getSession();
        if (users.size()==1) {
            Cookie logCookie = new Cookie("login",login);
            resp.addCookie(logCookie);
            Cookie pasCookie = new Cookie("password",password);
            resp.addCookie(pasCookie);
            session.setAttribute("auth",(Boolean)true);
            resp.sendRedirect("/chatovich/index.jsp");
        }
        else{
            resp.sendRedirect("/chatovich/loginTryAgain.jsp");

        }




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
