package projects.chatovich.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * redirects to the page to log in
 */
public class tologin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/chatovich/login.html");
        /*PrintWriter out = resp.getWriter();
        out.println("<script>window.location.href = \"/chatovich/register.html\";</script>");
        resp.setIntHeader("Refresh", 0);*/
    }
}
