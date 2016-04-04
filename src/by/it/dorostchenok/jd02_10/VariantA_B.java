package by.it.dorostchenok.jd02_10;

import by.it.dorostchenok.jd02_10.json.Order;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class VariantA_B {
    private Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

    public String toJson(Order order){
        String json = gson.toJson(order, Order.class);
        return json;
    }

    public Order fromJson(String json){
        return gson.fromJson(json, Order.class);
    }
}
