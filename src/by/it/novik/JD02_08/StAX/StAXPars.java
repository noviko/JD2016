package by.it.novik.JD02_08.StAX;


import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;

public class StAXPars {

    static String space = "";

    public static void main(String[] args) {

        try {
           String way = System.getProperty("user.dir") + "/src/by/it/novik/";

           String filename = way + "/JD02_07/project_connected_XSD.xml/";

           FileInputStream file = new FileInputStream(filename);

           XMLInputFactory inputFactory = XMLInputFactory.newInstance();

            XMLStreamReader reader = inputFactory.createXMLStreamReader(file);

            String elem = "";
           while (reader.hasNext()) {
               int i = reader.next();
               switch (i) {
                   case XMLStreamConstants.START_ELEMENT : {
                       System.out.println(space + "[" + reader.getLocalName() + "]");
                       space = space + "\t";
                       break;
                   }

                    case XMLStreamConstants.CHARACTERS : {

                        elem = elem.concat(reader.getText().trim());
                        break;
                    }


                    case XMLStreamConstants.END_ELEMENT : {

                        if (!elem.isEmpty())
                            System.out.println(space + elem);
                            space = space.substring(1);
                            elem = "";
                            System.out.println(space + "[/" + reader.getLocalName() + "]");
                            break;
                    }
               }
           }
        } catch (Exception e) {
            System.out.println("Failed " + e.toString());
        }
    }
}
