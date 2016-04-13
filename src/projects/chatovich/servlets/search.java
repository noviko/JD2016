package projects.chatovich.servlets;

import projects.chatovich.servlets.DAO.CityDAO;
import projects.chatovich.servlets.DAO.UserDAO;
import projects.chatovich.servlets.JD03_02.DB_it_academy.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * servlet for searching users who live in the city, that was entered on client's side
 */
public class search extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("ok");
        String city = req.getParameter("city");
        out.println(city);
        HashMap <Integer, User> users;

        try{
            CityDAO cityDAO = new CityDAO();
            int id_city = cityDAO.getId(city);
            out.println(id_city);
            UserDAO userDAO = new UserDAO();
            users = userDAO.getAll("where id_city = '"+id_city+"';");
            for (Map.Entry<Integer, User> entry : users.entrySet()) {
                out.println(entry.getValue());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        out.flush();


    }
}
