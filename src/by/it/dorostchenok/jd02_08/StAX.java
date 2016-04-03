package by.it.dorostchenok.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StAX {

    public void printXML(String xmlFilePath){
        XMLInputFactory factory = XMLInputFactory.newFactory();
        XMLStreamReader reader = null;
        try {
            reader = factory.createXMLStreamReader(new FileInputStream(xmlFilePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

        try {
            while (reader.hasNext()){
                int nextElement = reader.next();

                if (nextElement == reader.START_ELEMENT){
                    StringBuilder name = new StringBuilder(reader.getName().toString());
                    for (int j = 0; j < reader.getAttributeCount(); j++){
                        name.append(" [" + reader.getAttributeName(j) + "]=" + reader.getAttributeValue(j));
                    }
                    System.out.println(name);
                } else if (nextElement == reader.CHARACTERS && reader.getText().trim().length() > 0){
                    System.out.println(" " + reader.getText().trim());
                }


            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
