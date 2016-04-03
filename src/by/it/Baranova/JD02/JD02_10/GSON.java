package by.it.Baranova.JD02.JD02_10;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GSON {
    public static void main(String[] args) {
        Gson gson=new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        Room room=new Room("R1",1,"twin","yes",2,80,"yes");
        String json=gson.toJson(room);
        System.out.println(json);

        Room room2=gson.fromJson(json,Room.class);
        System.out.println("\n\ndev2=" + room2.toString());
    }
}
