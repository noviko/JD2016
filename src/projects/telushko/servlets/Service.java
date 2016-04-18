package projects.telushko.servlets;

import projects.telushko.servlets.dao.Account;
import projects.telushko.servlets.dao.AccountDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Service extends HttpServlet {

    public static void main(String [] args){
        boolean ok = false;
        String message="Операция ";

        Account account= new Account("test","test","test");
        AccountDAO accountDAO = new AccountDAO();

        List<Account> accounts = accountDAO.getAll("WHERE id=" + "1" + " LIMIT 0,1");
        if (accounts.size() > 0) {
            Account account_read = new Account();
            account_read=accounts.get(0);
            System.out.println(account_read);
        } else
        {System.out.println("из базы ничего не прочитано");}

        try {
            account.setId(0);
            if (0 == account.getId()) {
                message=message+" создания пользователя "+account+" ";
                ok = accountDAO.create(account);
            }
            if (ok) {message=message.concat("успешно завершена.");}
            else throw new Exception("сбой");
            System.out.println(message);

        } catch (Exception e) {
            message=message.concat("<b>не выполнена</b>.<br>"+e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        main(new String[]{});
        boolean ok = false;
        Account account= new Account("qwe","asd","zxc");
        String message="Операция ";
        try {
            AccountDAO accountDAO = new AccountDAO();
            List<Account> accounts = accountDAO.getAll("WHERE id=" + "1" + " LIMIT 0,1");
            message=message+" чтения пользователя ";
            if (accounts.size() > 0) {
                Account account_read = new Account();
                account_read=accounts.get(0);
                message=message+" чтения пользователя "+account_read;
                message=message.concat("успешно завершена.");
            } else
            {message=message.concat("<b>не выполнена</b>.<br>");}

            account.setId(0);
            if (0 == account.getId()) {
                message=message+" создания пользователя "+account+" ";
                ok = accountDAO.create(account);
            }
            if (ok) {message=message.concat("успешно завершена.");}
            else throw new Exception("сбой");
            System.out.println(message);

        } catch (Exception e) {
            message=message.concat("<b>не выполнена</b>.<br>"+e);
        }

        req.setAttribute("message", message);
        req.getRequestDispatcher("message.jsp").forward(req,resp);
    }
}
