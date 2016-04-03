package by.it.podelstchikova.jd02_01.implementation;

import java.util.ArrayList;
import java.util.List;

public class Good {

    private String name;
    private double price;
    public static List<Good> fixedListOfGoods = new ArrayList<Good>(){{
        add(new Good("Milk", 100));
        add(new Good("Bread", 200));
        add(new Good("Butter", 250));
        add(new Good("Coca Cola", 90));
        add(new Good("Vodka", 500));
    }};

    public Good(String name, double price){
        this.name = name;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
