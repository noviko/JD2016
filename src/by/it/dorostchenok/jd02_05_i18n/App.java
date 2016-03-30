package by.it.dorostchenok.jd02_05_i18n;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class App {

    private Locale locale;
    private ResourceBundle bundle;
    private String userName = System.getProperty("user.name");

    public App(Locale locale){
        this.locale = locale;
        this.bundle = ResourceBundle.getBundle("by.it.dorostchenok.jd02_05_i18n.res.resources",
                this.locale);
    }

    public App(){
        this(new Locale("en", "US"));
    }

    public void run() throws IOException {
        greetUser();
        printLocalizedDate();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;

        while (!"q".equals(line)) {
            line = br.readLine();
            if ("q".equals(line)) {
                System.out.println(bundle.getString("thanks"));
                break;
            }
            switchLoclae(line);
        }

    }

    private void greetUser(){
        System.out.format("%s, %s\n", bundle.getString("greetings"), userName);
    }

    private void printLocalizedDate(){
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, this.locale);
        System.out.format("%s: %s\n", bundle.getString("date"), df.format(new Date()));
    }

    private void switchLoclae(String s) throws IOException {
        if ("be".equals(s)) {
            this.locale = new Locale("be", "BY");
            this.bundle = ResourceBundle.getBundle("by.it.dorostchenok.jd02_05_i18n.res.resources",
                    this.locale);
            greetUser();
            printLocalizedDate();
        } else if ("en".equals(s)){
            this.locale = new Locale("en", "US");
            this.bundle = ResourceBundle.getBundle("by.it.dorostchenok.jd02_05_i18n.res.resources",
                    this.locale);
            greetUser();
            printLocalizedDate();
        } else if ("ru".equals(s)){
            this.locale = new Locale("ru", "RU");
            this.bundle = ResourceBundle.getBundle("by.it.dorostchenok.jd02_05_i18n.res.resources",
                    this.locale);
            greetUser();
            printLocalizedDate();
        } else {
            System.out.format("%s: %s\n", bundle.getString("nolocale"), s);
        }
    }
}
