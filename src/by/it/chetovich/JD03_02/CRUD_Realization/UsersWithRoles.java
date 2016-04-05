package by.it.chetovich.JD03_02.CRUD_Realization;

import by.it.chetovich.JD03_02.DB_it_academy.CN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Users with their roles + users'quantity
 */
public class UsersWithRoles {

    public static void main(String[] args) {

        try(Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
            Statement statementUser = connection.createStatement();
            Statement statementRole = connection.createStatement();
            Statement statementCountUsers = connection.createStatement()){

            ResultSet resultSetUser = statementUser.executeQuery("select * from users;");

            while (resultSetUser.next()){
                String user = resultSetUser.getString("name")+" "+resultSetUser.getString("surname");
                int id = resultSetUser.getInt("id_role");
                ResultSet resultSetRoles = statementRole.executeQuery("select * from role;");
                String role="";
                while (resultSetRoles.next()){
                    if (id==resultSetRoles.getInt("id_role")){
                        role = resultSetRoles.getString("role_type");
                        break;
                    }
                }
                System.out.println(user+": "+role);
            }

            ResultSet resultSetCount = statementCountUsers.executeQuery("select count(*) from users");
            resultSetCount.next();
            System.out.println("Users' quantity: "+resultSetCount.getInt(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }}
