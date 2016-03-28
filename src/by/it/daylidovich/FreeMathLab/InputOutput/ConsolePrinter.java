package by.it.daylidovich.FreeMathLab.InputOutput;

import by.it.daylidovich.FreeMathLab.Report.Director;

public class ConsolePrinter {
    public static void printToConsole(String text){
        System.out.println(text);
        Director.setAction(text);
    }
}
