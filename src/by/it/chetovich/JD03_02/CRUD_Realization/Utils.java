package by.it.chetovich.JD03_02.CRUD_Realization;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

/**
 * Methods for printing sql-select results
 */
public class Utils {

    public static void printSelectAll (ResultSet resultSet){

        Calendar today = Calendar.getInstance();
        try {
            while (resultSet.next()){
                Calendar birthday = Calendar.getInstance();
                birthday.setTime(resultSet.getDate("birth_date"));
                int age = today.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);
                String user = resultSet.getString("name")+" "+resultSet.getString("surname")+", "+age+"-year old, login: "+
                        resultSet.getString("login")+" password: "+resultSet.getString("password")+", email: "+
                        resultSet.getString("email")+" "+resultSet.getInt("id_role");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
