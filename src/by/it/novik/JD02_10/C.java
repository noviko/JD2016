package by.it.novik.JD02_10;


import by.it.novik.JD02_09.Automatic_Generation.Flights;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class C {

    public static void main(String[] args) {

        try {

            JAXBContext jc = JAXBContext.newInstance(Flights.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader("src/by/it/novik/JD02_10/project_plus_xsd.xml");
            System.out.println("XML-файл прочитан:");
            Flights flights = (Flights) u.unmarshal(reader);
            Gson gs = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
            String json = gs.toJson(flights);
            System.out.println(json);

            Flights flights1 = gs.fromJson(json, Flights.class);
            System.out.println(flights1.toString());


        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}



