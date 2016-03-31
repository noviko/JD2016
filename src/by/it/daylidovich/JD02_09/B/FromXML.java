package by.it.daylidovich.JD02_09.B;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FromXML {
    public static void main(String[] args) {
        try{
            JAXBContext context = JAXBContext.newInstance(Tours.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            FileReader reader = new FileReader("src\\by\\it\\daylidovich\\JD02_09\\B\\ToXML.xml");
            System.out.println("Complete.");
            Tours tours = (Tours) unmarshaller.unmarshal(reader);
            System.out.println(tours);
        } catch (JAXBException e) {
            System.out.println(e.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
