package by.it.akhmelev.JD03_03;

public class Main {
 public static void main(String[ ] args) {
    User user=new User("Сергей Иванович","siivanov","siivanov@mail.ru");
     user.setId(0);         //это в принципе лишнее, т.к. есть в конструкторе
     user.setFk_Role(2);    //это в принципе лишнее, т.к. есть в конструкторе
    UserDAO.getDAO().set(user);
 }
}
