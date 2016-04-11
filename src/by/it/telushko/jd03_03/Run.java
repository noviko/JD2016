package by.it.telushko.jd03_03;


import java.sql.SQLException;
import java.util.List;

public class Run {
    static void showAccounts(){
        //покажем все, что есть в таблице пользователей
        System.out.println("\nТаблица пользователей:");
        List<Account> users=new AccountDAO().getAll("");
        for (Account each:users) System.out.println(each);

    }

    public static void main(String[] args) throws SQLException {
        //инициализация работы с базой
        by.it.telushko.jd03_03.DAO.getDAO();
        AccountDAO accountDAO = new AccountDAO();
        by.it.telushko.jd03_03.RoleDAO roleDAO = new RoleDAO();
        System.out.println("Роли пользователей");
        for (int id = 1; id < 3; id++) {
            String role = roleDAO.getRole(id);
            System.out.println(id + ": " + role);
        }
        showAccounts();

        Account account = new Account("Nikolay", "niklogin", "12345678pass");
        account.setId(0);         //это в принципе лишнее, т.к. есть в конструкторе
        account.setFk_role(2);    //это в принципе лишнее, т.к. есть в конструкторе
        //добавим пользователя
        if (accountDAO.create(account)) System.out.println("\nДобавлен:" + account);
        showAccounts();

        //извлечем и обновим пользователя с email siivanov@mail.ru
        account = accountDAO.getAll("WHERE id>2").get(0);
        account.setLogin("NIKLOGIN");
        if (accountDAO.update(account)) System.out.println("\nИзменен:" + account);
        showAccounts();

        //удалим пользователя
        if (accountDAO.delete(account)) System.out.println("\nУдален:" + account);
        showAccounts();
    }
}
