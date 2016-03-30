package by.it.dorostchenok.jd02_05_i18n;

import java.io.IOException;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException {

        App app;

        if (args.length == 2 && args[0] != null && args[1] != null){
            app = new App(new Locale(args[0].toLowerCase(), args[1].toUpperCase()));
        } else {
            app = new App();
        }

        app.run();

    }
}
