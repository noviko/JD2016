package by.it.novik.JD03_01;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Qualifications_insert {
    public static void main(String[] args) {
        try (Connection connection =
                     DriverManager.getConnection
                             ("jdbc:mysql://localhost:2016/air?useUnicode=true&amp;characterEncoding=UTF-8", "root", "");
             Statement statement=connection.createStatement()) {

            statement.executeUpdate(
                    "insert into qualifications (Qualification) values ('Pilot_in_command')");
            statement.executeUpdate(
                    "insert into qualifications (Qualification) values ('Co-pilot')");
            statement.executeUpdate(
                    "insert into qualifications (Qualification) values ('Flight_engineer')"
            );
            statement.executeUpdate(
                    "insert into qualifications (Qualification) values ('Flight_attendant')"
            );

        }
            catch (Exception e){
                e.printStackTrace();
            }
    }
}
