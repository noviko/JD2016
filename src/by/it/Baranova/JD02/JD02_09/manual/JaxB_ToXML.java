package by.it.Baranova.JD02.JD02_09.manual;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class JaxB_ToXML {
    public static void main(String[] args){
        try {
            JAXBContext context=JAXBContext.newInstance(Project.class);
            Marshaller m=context.createMarshaller();
            Project pr=new Project() {
                {
                    Room.Bed_size b_s = new Room.Bed_size("king", "twin");
                    Room room = new Room("R1", 3, b_s, "yes", 1, 100, "yes");
                    this.addList(room);
                    b_s = new Room.Bed_size("queen", "queen");
                    room = new Room("R2", 4, b_s, "yes", 2, 130, "yes");
                    this.addList(room);
                    b_s=new Room.Bed_size("twin","none");
                    room=new Room("R3",1,b_s,"no",1,80,"yes");
                    this.addList(room);
                }

            };
            m.marshal(pr,new FileOutputStream("src/by/it/Baranova/JD02/JD02_09/manual/xml_01.xml"));
            System.out.println("XML-Файл создан");
            m.marshal(pr,System.out);

        } catch (FileNotFoundException e){
            System.out.println("XML-файл не может быть создан: " + e);
        }catch (JAXBException e){
            System.out.println("JAXB-контекст ошибочен " + e);

        }
    }
}
