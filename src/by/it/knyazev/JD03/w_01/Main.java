package by.it.knyazev.JD03.w_01;

/**
 * Created by Mac on 03.04.16.
 */

import java.io.File;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static String Mhost = "164.132.129.100:3306";
    public static String Mdb = "user12650_java";
    public static String Muser = "user12650_java";
    public static String Mpass = "javaschool";


    public static String path = "tables/nierazdvizhnye:16 ; tables/razdvizhnye:15 ; tables/zestaw:17 ; chairs:11 ; kitchens/mdf:6 ; kitchens/akril:5 ; kitchens/steklo:7 ; kitchens/massiv:8,22 ; kitchens/shpon:9 ; kitchens/dsp:3 ; kitchens/plastik:4";

    public static String autor = "root";

    public static String date = "2016-04-02 22:13:47"; // If empty auto Generated

    public static String[] arr = path.split(";");

    public static void main(String[] args) throws SQLException {
        Mysql.Connect();
        if (date.isEmpty()) DateGen();
        if (arr.length >= 2) MultiPath();
        else{
            String[] temp = arr[0].split(":");
            String folder = temp[0].trim();
            String category = temp[1].trim();
            Request(category, folder);
        }
        Mysql.CloseConnect();
    }

    public static void MultiPath() throws SQLException {
        for (int i = 0; i < arr.length; i++) {
            String[] temp = arr[i].split(":");
            String folder = temp[0].trim();
            String category = temp[1].trim();
            //System.out.println(folder + " " + category);
            Request(category, folder);
        }
    }

    public static void Request(String category, String folder) throws SQLException {
        List<String> list = new ArrayList<String>();
        try {
            String[] array = new File("/Applications/MAMP/sites/borimebel.loc/img/" + folder).list();
            for(int i = 0; i < array.length; i++) {
                list.add(array[i].trim());
            }
            Manager.Manager(category, folder, list);
            //System.out.println(array.length + folder + category);

        }catch (Exception e){
            System.out.println("Step 1"+e.getMessage());
        }
    }

    public static void DateGen(){
        LocalDateTime TimeDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        date = TimeDate.format(formatter);
    }
}