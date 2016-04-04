package by.it.chetovich.JD03_02.crud;

import by.it.chetovich.JD03_01.CN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * CRUD operations
 */
public class CRUD_operations {

    public static int ConnectionExecuteUpdate (String sql){

        int rows = 0;
        try(Connection connection = DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);
            Statement statement = connection.createStatement()) {
            rows = statement.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    public static ResultSet ConnectionExecuteQuery (String sql) {

        ResultSet resultSet = null;
        try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
             resultSet = statement.executeQuery(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }



    public static void insertUsers
             (String name, String surname, String login, String password, String birth_date, String id_role, String email){

        String sql = "insert into users (name, surname, login, password, birth_date, id_role, email) " +
                "values ('"+name+"','"+surname+"','"+login+"','"+password+"','"+birth_date+"',"+id_role+", '"+email+"');";
        ConnectionExecuteUpdate(sql);

    }

    public static void insertRole(String role_type ){

        String sql = "insert into role (role_type) values ('"+role_type+"');";
        ConnectionExecuteUpdate(sql);

    }

    public static void insertCities(String city){

            String sql = "insert into cities (city) values ('"+city+"');";
            ConnectionExecuteUpdate(sql);
    }

    public static void insertProfiles(String id_user, String id_city, String description){

        String sql = "insert into profiles (id_user,id_city,description) values ('"+id_user+"','"+id_city+"','"+description+"');" ;
        ConnectionExecuteUpdate(sql);

    }

    public static void insertFeedbacks(String id_feedback, String feedback_from, String feedback_to, String feedback_text){

        String sql = "insert into profiles (id_feedback, feedback_from, feedback_to, feedback_text) " +
                "values ('"+id_feedback+"','"+feedback_from+"','"+feedback_to+"','"+feedback_text+"');" ;
        ConnectionExecuteUpdate(sql);


    }


}
