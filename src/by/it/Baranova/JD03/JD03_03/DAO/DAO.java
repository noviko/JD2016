package by.it.Baranova.JD03.JD03_03.DAO;

import by.it.Baranova.JD03.JD03_03.CN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class DAO {

    private static DAO dao; //синглтон для DAO
    static DAO getDAO() {   //метод, который создает DAO или возвращает существующий экземпляр
        if (dao == null) {
            dao = new DAO();    //в момент создания DAO удобно создавать соединения.
                                //Но потом трудно их уничтожать. Нужно это делать явно из кода.
        }
        return dao;
    }

    static void closeDAO() {   //метод, который уничтожает DAO
        dao = null; //Тут можно тоже закрывать соединение.
    }

    //Create Update Delete
    static int executeUpdate(String sql) {
        //System.out.println("--- Sql="+sql); //отладка
        int result = -1;
        try (Connection connection = DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);
             Statement statement = connection.createStatement();) {
            result = statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

