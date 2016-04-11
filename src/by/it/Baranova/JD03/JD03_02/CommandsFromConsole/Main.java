package by.it.Baranova.JD03.JD03_02.CommandsFromConsole;


import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main (String[] args) throws SQLException, IOException {

        //Working with table BedSize
        System.out.println("Insert number of a command");
        System.out.println("1: Show the table");
        System.out.println("2: Add a row");
        System.out.println("3: Select a row");
        System.out.println("4: Change a row");
        System.out.println("5: Delete a row");

        String rLine=ReadingFromConsole.ReadLine();
        while (rLine.trim().length()!=0){
            try{
                String line="";
                String id="";
                switch (rLine.trim()){
                    case "1":
                        WorkingWithDatabase.readingTable();
                        break;
                    case "2":
                        System.out.println("Write a bed size to insert");
                        line=ReadingFromConsole.ReadLine();
                        WorkingWithDatabase.insert(line);
                        break;
                    case "3":
                        System.out.println("Write a bed size id to be print");
                        line=ReadingFromConsole.ReadLine();
                        WorkingWithDatabase.select(line);
                        break;
                    case "4":
                        System.out.println("Write a bed size id to be updated");
                        id=ReadingFromConsole.ReadLine();
                        System.out.println("Write a new name of bed size");
                        line=ReadingFromConsole.ReadLine();
                        WorkingWithDatabase.update(id,line);
                        break;
                    case "5":
                        System.out.println("Write a bed size id to be deleted");
                        id=ReadingFromConsole.ReadLine();
                        WorkingWithDatabase.delete(id);
                        break;
                    default:
                        System.out.println("You insert a wrong number of command");
                }
            } catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("Insert number of a command");
            rLine=ReadingFromConsole.ReadLine();
        }

    }

}
