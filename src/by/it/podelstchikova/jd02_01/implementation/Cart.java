package by.it.podelstchikova.jd02_01.implementation;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Good> goodsList;

    public Cart(){
        this.goodsList = new ArrayList<>();
    }

    public void addGoods(Good good){
        goodsList.add(good);
    }

    public List<Good> getAllGoods(){
        return goodsList;
    }
}
