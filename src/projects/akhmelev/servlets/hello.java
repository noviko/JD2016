package projects.akhmelev.servlets;

import projects.akhmelev.servlets.dao.Cnn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

public class hello extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("Hello world");
        out.flush(); //ВАЖНО! Иначе вывод будет неустойчивым...
        try {
            Cnn.getConnection().close();
        } catch (Exception e) {
            out.println(e+" Bad");
            e.printStackTrace();
        }
    }
}
