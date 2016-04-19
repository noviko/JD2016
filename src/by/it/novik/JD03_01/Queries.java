package by.it.novik.JD03_01;


import java.sql.SQLException;
import java.sql.Statement;

public class Queries {

    public static void createATable(Statement stat) throws SQLException {

        stat.executeUpdate("CREATE TABLE crewmen (\n" +
                "ID int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,\n" +
                "Name text NOT NULL,\n" +
                "Surname text NOT NULL,\n" +
                "Experience int(11) NOT NULL,\n" +
                "FK_qualification varchar(100) NOT NULL);"
        );

        stat.executeUpdate("CREATE TABLE flights (\n" +
                "ID int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,\n" +
                "Date varchar(250) NOT NULL,\n" +
                "Time varchar(250) NOT NULL,\n" +
                "FK_pilot_in_command varchar(100) NOT NULL,\n" +
                "FK_co_pilot varchar(100) NOT NULL,\n" +
                "FK_flight_engineer varchar(100) NOT NULL,\n" +
                "FK_flight_attendant varchar(100) NOT NULL);"
        );
        stat.executeUpdate("CREATE TABLE qualifications (\n" +
                "ID int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,\n" +
                "Qualification varchar(100) NOT NULL);"
        );

            System.out.println("Your tables created.");

    }
    public static void deleteATable(Statement stat) throws SQLException {
        stat.executeUpdate("drop table crewmen");
        stat.executeUpdate("drop table flights");
        stat.executeUpdate("drop table qualifications");

        System.out.println("All the tables has been successfully removed.");
    }

    public static void insertAData(Statement stat) throws SQLException {
        stat.executeUpdate("insert into qualifications (Qualification) values ('pilot-in-command');"
        );
        stat.executeUpdate("insert into qualifications (Qualification) values ('co-pilot');"
        );
        stat.executeUpdate("insert into qualifications (Qualification) values ('flight-engineer');"
        );
        stat.executeUpdate("insert into qualifications (Qualification) values ('flight-attendant');"
        );
        stat.executeUpdate("insert into crewmen(Surname,Name,Experience,FK_qualification) values ('Ivanov','Petr',15,1);"
        );
        stat.executeUpdate("insert into crewmen(Surname,Name,Experience,FK_qualification) values ('Gerasimov','Ivan',18,1);"
        );
        stat.executeUpdate("insert into crewmen(Surname,Name,Experience,FK_qualification) values ('Petrov','Nikolay',10,2);"
        );
        stat.executeUpdate("insert into crewmen(Surname,Name,Experience,FK_qualification) values ('Kozlov','Michail',11,2);"
        );
        stat.executeUpdate("insert into crewmen(Surname,Name,Experience,FK_qualification) values ('Morozov','Gena',6,3);"
        );
        stat.executeUpdate("insert into crewmen(Surname,Name,Experience,FK_qualification) values ('Vishniavsky','Vladimir',5,3);"
        );
        stat.executeUpdate("insert into crewmen(Surname,Name,Experience,FK_qualification) values ('Nikolaeva','Elizaveta',6,4);"
        );
        stat.executeUpdate("insert into crewmen(Surname,Name,Experience,FK_qualification) values ('Minina','Olga',4,4);"
        );
        stat.executeUpdate("insert into flights (Date,Time,FK_pilot_in_command,FK_co_pilot,FK_flight_engineer,FK_flight_attendant) values ('01.01.2016','06.10',1,3,5,7);"
        );
        stat.executeUpdate("insert into flights (Date,Time,FK_pilot_in_command,FK_co_pilot,FK_flight_engineer,FK_flight_attendant) values ('01.01.2016','08.25',2,4,6,8);"
        );

        System.out.println("Data inserted successfully.");
    }
}
