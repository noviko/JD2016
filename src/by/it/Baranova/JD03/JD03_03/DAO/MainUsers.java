package by.it.Baranova.JD03.JD03_03.DAO;



import java.sql.SQLException;
import java.util.List;

public class MainUsers {

    static void showUsers(){
        //покажем все, что есть в таблице пользователей
        System.out.println("\nТаблица пользователей:");
        List<Users> users=new UsersDAO().getAll("");
        for (Users each:users) System.out.println(each);

    }

    public static void main(String[] args) throws SQLException {
        //инициализация работы с базой
        DAO.getDAO();
        UsersDAO userDAO = new UsersDAO();
        RoleDAO roleDAO = new RoleDAO();
        System.out.println("Роли пользователей");
        for (int id = 1; id < 3; id++) {
            String role = roleDAO.getRole(id);
            System.out.println(id + ": " + role);
        }
        System.out.println();

        showUsers();
/*
        Users users=new Users("PashkaT","12345","Pavel","Tyshkevich","+375293456564","pt@tut.by");
        users.setIdUsers(0);
        users.setFKRole(2);

        //добавим пользователя
        if (userDAO.create(users)) System.out.println("\nДобавлен:" + users);
        showUsers();

        //извлечем и обновим пользователя с email siivanov@mail.ru
        users = userDAO.getAll("WHERE idUsers>3").get(0);
        users.setLogin("pash_tysh");
        if (userDAO.update(users)) System.out.println("\nИзменен:" + users);
        showUsers();

        //удалим пользователя
        if (userDAO.delete(users)) System.out.println("\nУдален:" + users);
        showUsers();*/
    }
}
