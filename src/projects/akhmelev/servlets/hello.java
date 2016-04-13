 import java.io.PrintWriter;
  
  public class hello extends HttpServlet {
 -    @Override
 -    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 -        PrintWriter out = resp.getWriter();
 -        out.println("Hello world");
 -        out.flush(); //ВАЖНО! Иначе вывод будет неустойчивым...
 +        @Override
 +        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 +            PrintWriter out = resp.getWriter();
 +            out.println("Hello world");
 +            out.flush(); //ВАЖНО! Иначе вывод будет неустойчивым...
  
 -    }
 +        }
  
