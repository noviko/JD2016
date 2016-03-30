package by.it.daylidovich.JD02_09.B;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ToXML {
    public static void main(String[] args) {
        try{
            JAXBContext context = JAXBContext.newInstance(Tours.class);
            Marshaller marshaller = context.createMarshaller();
            Tours tours = new Tours(){
                {
                    Tour tour1 = new Tour("relaxing", "Egypt", 500, "aircraft", "4", "HB");
                    Tour tour2 = new Tour("relaxion", "Montenegro", 900, "train", "3", "ALL");
                    Tour tour3 = new Tour("shopping", "Italy", 300, "bus", "3", "BB");
                    this.add(tour1);
                    this.add(tour2);
                    this.add(tour3);
                }
            };
            marshaller.marshal(tours, new FileOutputStream("src\\by\\it\\daylidovich\\JD02_09\\B\\ToXML.xml"));
            System.out.println("Complete");
        } catch (JAXBException e) {
            System.out.println(e.toString());
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        }
    }
}
