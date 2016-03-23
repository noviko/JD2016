package by.it.daylidovich.FreeMathLab.Report;

import by.it.daylidovich.FreeMathLab.Logger.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Report {
    private static File report;
    private static PrintWriter printer;

    public Report(String name){
        String nameOld = name;
        name = "src\\by\\it\\daylidovich\\FreeMathLab\\Report\\Reports\\" + name + ".txt";
        report = new File(name);
        openReport();
        recordReport(nameOld);
    }
//метод делает запись в отчет
    public static void recordReport(String text){
        printer.println(text);
        printer.println();
    }

    private static void openReport(){
        try {
            printer = new PrintWriter(new FileWriter(report));
        } catch (IOException e) {
            Logger.writeLog(e.toString(), new Date(System.currentTimeMillis()));
        }
    }
    public static void closeReport(){
        printer.close();
    }
}
