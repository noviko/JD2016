package by.it.chetovich.JD03_02.CRUD_Realization;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Methods for printing sql-select results
 */
public class Utils {

    public static void printSelectAll (ResultSet resultSet){

        try {
            while (resultSet.next()){
                //String user =
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
