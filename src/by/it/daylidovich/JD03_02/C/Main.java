package by.it.daylidovich.JD03_02.C;

import by.it.daylidovich.JD03_02.A_crud.CRUD_Users;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String consoleLine = "";
        while (!consoleLine.equals("exit")){
            System.out.println("Введите действие:\n" +
                    "\"read\" для вывода таблицы в консоль,\n" +
                    "\"create\" для создания новой записи,\n" +
                    "\"update\" для изменения записи,\n" +
                    "\"delete\" для удаления записи,\n" +
                    "\"exit\" для выхода.\n");
            consoleLine = readConsole();
            try{
                switch (consoleLine){
                    case ("read"):{
                        CRUD_Users.read();
                        break;
                    }
                    case ("create"):{
                        System.out.println("Введите имя.");
                        String name = readConsole();
                        System.out.println("Введите фамилию.");
                        String surname = readConsole();
                        System.out.println("Введите Email.");
                        String Email = readConsole();
                        System.out.println("Введите логин.");
                        String Login = readConsole();
                        System.out.println("Введите пароль.");
                        String password = readConsole();
                        System.out.println("Введите ключ пользователя.");
                        int role = Integer.parseInt(readConsole());
                        CRUD_Users.create(name, surname, Email, Login, password , role);
                        break;
                    }
                    case ("update"):{
                        System.out.println("Введите номер изменяемой записи.");
                        int id = Integer.parseInt(readConsole());
                        System.out.println("Введите имя.");
                        String name = readConsole();
                        System.out.println("Введите фамилию.");
                        String surname = readConsole();
                        System.out.println("Введите Email.");
                        String Email = readConsole();
                        System.out.println("Введите логин.");
                        String Login = readConsole();
                        System.out.println("Введите пароль.");
                        String password = readConsole();
                        System.out.println("Введите ключ пользователя.");
                        int role = Integer.parseInt(readConsole());
                        CRUD_Users.update(id, name, surname, Email, Login, password , role);
                        break;
                    }
                    case ("delete"):{
                        System.out.println("Введите номер удаляемой записи.");
                        int id = Integer.parseInt(readConsole());
                        CRUD_Users.delete(id);
                        break;
                    }
                    case ("exit"):{
                        System.out.println("Goodbye!");
                        break;
                    }
                    default:{
                        System.out.println("Некорректный ввод.");
                    }
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
            System.out.println();
        }
    }

    private static String readConsole(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try{
            line = reader.readLine().trim();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        return line;
    }
}
