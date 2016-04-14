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

        String city = req.getParameter("city");

        HashMap <Integer, User> users;

        try{
            CityDAO cityDAO = new CityDAO();
            int id_city = cityDAO.getId(city);

            UserDAO userDAO = new UserDAO();
            users = userDAO.getAll("where id_city = '"+id_city+"';");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        


    }
}
