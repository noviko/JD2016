package by.it.daylidovich.FreeMathLab.Report;

public class Director {
    private static ReportBuilder report;

    public static void setStandartReport(String name){
        report = new StandartReport();
        report.createHeader(name);
        report.createStartTime();
    }

    public static void setAction(String action){
        report.createAction(action);
    }

    public static void endReport(){
        report.createStopTime();
    }
}
