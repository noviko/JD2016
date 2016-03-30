package by.it.Baranova.JD02.JD02_10.C;

import by.it.Baranova.JD02.JD02_10.C.Room;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

public class GSON_03 {
    public static void main(String[] args) {
        try {
            JAXBContext jc=JAXBContext.newInstance(Project.class);
            Unmarshaller u=jc.createUnmarshaller();
            Marshaller m=jc.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

            FileReader reader=new FileReader("src/by/it/Baranova/JD02/JD02_10/C/Project.xml");
            System.out.println("XML-файл прочитан:");
            Project project=(Project) u.unmarshal(reader);
            Gson gson=new GsonBuilder().serializeNulls().setPrettyPrinting().create();
            String json=gson.toJson(project);
            System.out.println(json);

            Project project2=gson.fromJson(json,Project.class);
            m.marshal(project2,new FileOutputStream("src/by/it/Baranova/JD02/JD02_10/C/xml_01.xml"));
            m.marshal(project2,System.out);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JAXBException e){
            e.printStackTrace();
        }

    }
}
