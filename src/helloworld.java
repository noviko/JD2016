import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class helloworld extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req,
                           HttpServletResponse resp)
            throws ServletException, IOException
    {
        super.service(req, resp);

        resp.setContentType("text/html");
        //получаем поток вывода
        PrintWriter out=resp.getWriter();
        out.println("Hello world! (from it-academy)");
        out.flush(); //ВАЖНО! Иначе вывод будет неустойчивым...
    }
}
