package by.it.daylidovich.JD02_08.B;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;

public class Parser_StAX {
    public static void main(String[] args) {
        try {
            FileInputStream stream = new FileInputStream("src\\by\\it\\daylidovich\\JD02_07\\A\\XML.xml");
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(stream);
            String element = "";
            String tab = "";

            while (reader.hasNext()){
                int type = reader.next();
                switch (type){
                    case XMLStreamConstants.START_ELEMENT:
                    {
                        System.out.println(tab+"[" + reader.getLocalName() + "]");
                        tab=tab+"\t";
                        break;
                    }
                    case XMLStreamConstants.CHARACTERS:
                    {
                        element=element.concat(reader.getText().trim());
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT:
                    {
                        if (!element.isEmpty())
                            System.out.println(tab+element);
                        tab=tab.substring(1);
                        element="";
                        System.out.println(tab+"[/" + reader.getLocalName() + "]");
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
