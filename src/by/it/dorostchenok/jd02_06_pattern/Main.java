package by.it.dorostchenok.jd02_06_pattern;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger();

        logger.log("Starting program!", Logger.LOG_LEVEL.DEBUG);
        logger.log("Log message");
        logger.log("Could not open file", Logger.LOG_LEVEL.ERROR);
        logger.log("Exiting..", Logger.LOG_LEVEL.DEBUG);
    }
}
