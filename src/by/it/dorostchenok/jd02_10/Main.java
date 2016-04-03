package by.it.dorostchenok.jd02_10;

import by.it.dorostchenok.jd02_10.json.Address;
import by.it.dorostchenok.jd02_10.json.Order;
import by.it.dorostchenok.jd02_10.json.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

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

        // Variant C
        System.out.println("################ Variant C ###################");
        String xmlFile = "src/by/it/dorostchenok/jd02_09/variant_b_c/product.xml";
        String output = "src/by/it/dorostchenok/jd02_10/new_product.xml";
        VariantC c = new VariantC();
        by.it.dorostchenok.jd02_09.variant_b_c.generated.Product p = c.XmlToObject(xmlFile);
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        String json1 = gson.toJson(p, by.it.dorostchenok.jd02_09.variant_b_c.generated.Product.class);
        // System.out.println(json1);

        by.it.dorostchenok.jd02_09.variant_b_c.generated.Product newProduct =
                gson.fromJson(json1, by.it.dorostchenok.jd02_09.variant_b_c.generated.Product.class);

        c.ObjectToXml(output);

        try {
            byte[] f1 = Files.readAllBytes(Paths.get(xmlFile));
            byte[] f2 = Files.readAllBytes(Paths.get(output));

            System.out.println("Files are equls: " + Arrays.equals(f1, f2));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
