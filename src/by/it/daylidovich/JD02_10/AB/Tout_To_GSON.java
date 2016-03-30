package by.it.daylidovich.JD02_10.AB;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Tout_To_GSON {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        Tour tour1 = new Tour("relaxing", "Egypt", 500, "aircraft", "4", "HB");
        // задание А
        String json = gson.toJson(tour1);
        System.out.println(json);
        // задание B
        Tour tourDem = gson.fromJson(json, Tour.class);
        System.out.println(tourDem.toString());
    }
}
