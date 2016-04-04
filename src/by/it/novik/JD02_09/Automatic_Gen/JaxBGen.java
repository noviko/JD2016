package by.it.novik.JD02_09.Automatic_Gen;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JaxBGen {
    public static void main(String[] args) {
        try {

            JAXBContext jc = JAXBContext.newInstance(Flights.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader("src/by/it/novik/JD02_09/Automatic_Gen/project_plus_xsd.xml");
            System.out.println("XML-файл прочитан:");
            Flights flights = (Flights) u.unmarshal(reader);
            System.out.println(flights.toString());

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
