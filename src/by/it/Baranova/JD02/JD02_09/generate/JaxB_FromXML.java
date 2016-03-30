package by.it.Baranova.JD02.JD02_09.generate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class JaxB_FromXML {
    public  static void main(String[] args){
        try {
            JAXBContext jc=JAXBContext.newInstance(by.it.Baranova.JD02.JD02_09.generate.Project.class);
            Unmarshaller u=jc.createUnmarshaller();
            FileReader reader=new FileReader("src/by/it/Baranova/JD02/JD02_09/generate/Project.xml");
            System.out.println("XML-файл прочитан:");
            Project project=(Project) u.unmarshal(reader);
            System.out.println(project);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JAXBException e){
            e.printStackTrace();
        }
    }
}
