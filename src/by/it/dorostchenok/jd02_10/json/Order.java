package by.it.dorostchenok.jd02_10.json;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int id;
    private Address address;
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(Product product) {
        this.products.add(product);
    }

    public Order(int id, Address address){
        products = new ArrayList<>();
        this.id = id;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", address=" + address +
                ", products=" + products +
                '}';
    }
}
