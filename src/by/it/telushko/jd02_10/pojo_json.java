package by.it.telushko.jd02_10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Владимир on 03.04.2016.
 */
public class pojo_json {
    public static void main(String [] args){
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        String[] contacts = {"number","email","address"};
        Client client = new Client("Vladimir",contacts);

        String json = gson.toJson(client);
        System.out.println(json);

        Client client_de=gson.fromJson(json, Client.class);
        System.out.println("new class client_de:\n" + client.toString());
        System.out.println("");
    }
}
