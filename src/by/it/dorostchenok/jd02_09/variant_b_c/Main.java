package by.it.dorostchenok.jd02_09.variant_b_c;

import by.it.dorostchenok.jd02_09.variant_b_c.generated.Product;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

public class Main {

    private static String outputFile = "src/by/it/dorostchenok/jd02_09/variant_b_c/product.xml";

    public static void main(String[] args) {
        System.out.println("Marshalling #########################");
        marshalling();
        System.out.println("Unmarshalling #########################");
        unmarshalling();
    }




    private static void marshalling(){
        try {
            JAXBContext context = JAXBContext.newInstance(Product.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // pretty prints
            Product product = new Product();
            product.setDescription("New product description");
            product.setName("Mega product");
            product.setPrice(100);

            marshaller.marshal(product, System.out);
            marshaller.marshal(product, new FileOutputStream(new File(outputFile)));


        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void unmarshalling(){
        try {
            JAXBContext context = JAXBContext.newInstance(Product.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            FileReader fileReader = new FileReader(outputFile);

            Product product = (Product) unmarshaller.unmarshal(fileReader);
            System.out.println(product);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
