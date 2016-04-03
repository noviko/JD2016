package by.it.podelstchikova.JD02_05;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PrintDate {

    public static void printDate (Locale locale){

        Date d = new Date();
        DateFormat df = new SimpleDateFormat("EEEE, d MMMM yyyy HH:mm:ss",locale);
        System.out.println(df.format(d));


    }
}
