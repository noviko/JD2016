package by.it.daylidovich.FreeMathLab.Report;

public class Director {
    private static ReportBuilder builder;

    public static void setStandartReport(String name){
        builder = new StandartReport();
        builder.createHeader(name);
        builder.createStartTime();
    }

    public static void setAction(String action){
        builder.createAction(action);
    }

    public static void endReport(){
        builder.createStopTime();
    }
}
