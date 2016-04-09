package by.it.Baranova.JD04_01;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class HelloWorld extends HttpServlet {

    @Override
    protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        super.service(request,response);

        response.setContentType("text/html");

        PrintWriter out=response.getWriter();
        out.println("Hello everybody!!");
        out.flush();
    }

}
