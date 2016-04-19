package by.it.novik.JD03_01;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectFrom {
    public static void main(String[] args) {
        try (Connection connection =
                     DriverManager.getConnection
                             ("jdbc:mysql://localhost:2016/air?useUnicode=true&amp;characterEncoding=UTF-8", "root", "");
        Statement statementCrewmen = connection.createStatement();
        Statement statementQualific = connection.createStatement()) {

                ResultSet resultSetCrewmen = statementCrewmen.executeQuery("select * from crewmen;");


                while (resultSetCrewmen.next()){
                    String crewmen = resultSetCrewmen.getString("Surname")+" "+resultSetCrewmen.getString("Name") + " " + resultSetCrewmen.getString("Experience");
                    int id = resultSetCrewmen.getInt("FK_qualification");
                    ResultSet resultSetQualific = statementQualific.executeQuery("select * from qualifications;");
                    String qualification = " ";
                    while (resultSetQualific.next()){
                        if (id == resultSetQualific.getInt("ID")){
                            qualification = resultSetQualific.getString("Qualification");
                            break;
                        }
                    }
                    System.out.println(crewmen + " " + qualification);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
