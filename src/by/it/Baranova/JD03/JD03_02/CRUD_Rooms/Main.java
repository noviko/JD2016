package by.it.Baranova.JD03.JD03_02.CRUD_Rooms;


import java.sql.SQLException;

public class Main {
    public static void main (String[] args) throws SQLException {
        WorkingWithDatabase.readingTable();
        WorkingWithDatabase.create_read();
        WorkingWithDatabase.update_read();
        WorkingWithDatabase.delete_read();
    }

}
