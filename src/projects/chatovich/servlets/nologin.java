package projects.chatovich.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 */
public class nologin extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/chatovich/register.jsp");
        /*PrintWriter out = resp.getWriter();
        out.println("<script>window.location.href = \"/chatovich/register.jsp\";</script>");
        resp.setIntHeader("Refresh", 0);*/
    }
}
