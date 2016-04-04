package by.it.dorostchenok.jd02_10;

import by.it.dorostchenok.jd02_09.variant_b_c.generated.Product;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

public class VariantC {

    public Product XmlToObject(String xmlFilePath){
        Product product = null;
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(Product.class);

            Unmarshaller unmarshaller = context.createUnmarshaller();
            FileReader fileReader = new FileReader(xmlFilePath);

            product = (Product) unmarshaller.unmarshal(fileReader);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return product;
    }

    public void ObjectToXml (String output){
        try {
            JAXBContext context = JAXBContext.newInstance(Product.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // pretty prints
            Product product = new Product();
            product.setDescription("New product description");
            product.setName("Mega product");
            product.setPrice(100);

            // marshaller.marshal(product, System.out);
            marshaller.marshal(product, new FileOutputStream(new File(output)));


        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
