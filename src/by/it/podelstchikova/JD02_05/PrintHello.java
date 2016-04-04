package by.it.podelstchikova.JD02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public class PrintHello {

    public static void printHello(Locale locale){

        ResourceBundle resource = ResourceBundle.getBundle("by.it.podelstchikova.JD02_05.hello", locale);
        System.out.println(resource.getString("line1"));
    }
}
