package by.it.chetovich.JD02_09.manual;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * JaxB_fromXML
 */
public class JaxB_fromXML {

    public static void main(String[ ] args) {

            Hospital hospital = GetJAXB_Hospital.getHospital();
            System.out.println(hospital);

            /*Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
            //маршаллизация
            String json = gson.toJson(hospital);
            System.out.print(json);
            //демаршаллизация
//            Dev dev2=gson.fromJson(json, Dev.class);
//            System.out.print("\n\ndev2=" + dev2.toString());*/


    }
}
