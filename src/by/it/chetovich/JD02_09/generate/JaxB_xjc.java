package by.it.chetovich.JD02_09.generate;
import by.it.chetovich.JD02_09.manual.Hospital;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * JaxB_xjc
 */
public class JaxB_xjc {

    public static void main(String[ ] args) {
        try {

            JAXBContext jc = JAXBContext.newInstance(Hospital.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader(System.getProperty("user.dir")+"/src/by/it/chetovich/JD02_09/generate/xml_generate.xml");
            System.out.println("XML-файл прочитан:");
            Hospital hospital = (Hospital) u.unmarshal(reader);
            System.out.println(hospital);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
