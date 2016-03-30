package by.it.chetovich.JD02_09.manual;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Yultos_ on 30.03.2016.
 */
public class GetJAXB_Hospital {

    public static Hospital getHospital()  {

        JAXBContext jc = null;
        try {
            jc = JAXBContext.newInstance(Hospital.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader(System.getProperty("user.dir")+"/src/by/it/chetovich/JD02_09/manual/xml_01.xml");
            System.out.println("XML-файл прочитан:");
            return  (Hospital) u.unmarshal(reader);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
