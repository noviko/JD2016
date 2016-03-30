package by.it.daylidovich.JD02_10.C;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSON_To_XML {
    public static void main(String[] args) {
        // create json
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        Tours tours = new Tours(){
            {
                Tour tour1 = new Tour("relaxing", "Egypt", 500, "aircraft", "4", "HB");
                Tour tour2 = new Tour("shopping", "Italy", 300, "aircraft", "3", "BB");
                Tour tour3 = new Tour("traveling", "Spain", 650, "boat", "3+", "ALL");
                this.add(tour1);
                this.add(tour2);
                this.add(tour3);
            }
        };
        String json = gson.toJson(tours);

        // json to xml

    }
}
