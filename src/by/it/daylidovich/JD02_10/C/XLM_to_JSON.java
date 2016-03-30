package by.it.daylidovich.JD02_10.C;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

public class XLM_to_JSON {
    public static void main(String[] args) {
        try{
            //XML to Class
            JAXBContext context = JAXBContext.newInstance(Tours.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            FileReader reader = new FileReader("src\\by\\it\\daylidovich\\JD02_10\\C\\XML.xml");
            Tours tours = (Tours) unmarshaller.unmarshal(reader);

            //Class to json
            Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
            String json = gson.toJson(tours);
            System.out.println("JSOM from XML.");
            System.out.println(json);

            //json to class
            Tours toursOut = gson.fromJson(json, Tours.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(toursOut, new FileOutputStream("src\\by\\it\\daylidovich\\JD02_10\\C\\From_JSON.xml"));
        } catch (JAXBException | FileNotFoundException e) {
            System.out.println(e.toString());
        }
    }
}
