package by.it.dorostchenok.jd02_10;

import by.it.dorostchenok.jd02_10.json.Address;
import by.it.dorostchenok.jd02_10.json.Order;
import by.it.dorostchenok.jd02_10.json.Product;

public class Main {
    public static void main(String[] args) {
        VariantA_B a = new VariantA_B();

        Product product = new Product("iPhone SE", 400);
        Address address = new Address("Belarus", "Minsk", "Masherava", 14, 220004);
        Order order = new Order(12, address);
        order.setProducts(product);
        // to JSON
        String json = a.toJson(order);
        System.out.println(json);
        // From JSON
        Order ord = a.fromJson(json);
        System.out.println(ord);
    }
}
