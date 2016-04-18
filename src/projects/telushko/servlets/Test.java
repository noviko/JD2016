package projects.telushko.servlets;

import projects.telushko.servlets.dao.Account;
import projects.telushko.servlets.dao.AccountDAO;


public class Test {
    public static void mmain(String[]args){

        Account account= new Account("qwe","asd","zxc");
        AccountDAO accountDAO = new AccountDAO();
        account.setId(0);
        String message="Операция ";
        boolean ok = false;
        if (0 == account.getId()) {
            message=message+" создания пользователя "+account+" ";
            ok = accountDAO.create(account);
        }
        if (!ok) {message=message.concat("успешно завершена.");}
        System.out.println(message);
    }
}
