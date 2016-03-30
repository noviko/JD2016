package by.it.dorostchenok.jd02_06_pattern;

import java.io.*;
import java.util.Date;

public class Logger {
    private static Logger instance;
    private static File file = new File(System.getProperty("user.dir") + "/src/by/it/dorostchenok/jd02_06_pattern/log.txt");
    public enum LOG_LEVEL {
        DEBUG,
        INFO,
        ERROR
    }

    private Logger(){}

    public static synchronized Logger getLogger(){
        if (instance == null){
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) throws IOException {
        log(message, LOG_LEVEL.INFO);

    }

    public void log(String message, LOG_LEVEL level) throws IOException {
        if (!file.exists()){
            file.createNewFile();
        }
        try(PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file, true)))) {
            writer.println(new Date()+ ": [" + level + "] : " + message);
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
