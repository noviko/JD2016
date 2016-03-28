package by.it.telushko.jd_02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SAX extends DefaultHandler {

    private String tab = "";
    private String value;

    public  static void main(String[] args){
        try{

            String path="src/by/it/telushko/JD02_07_project_plan/client_xsd.xml";
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            SAX myImpSAX = new SAX();

            parser.parse(new File(path),myImpSAX);
        }
        catch (Exception e){System.out.println("Ошибка" +e.toString());}
    }

    @Override
    public void startDocument() throws SAXException{System.out.println("Начало обработки");}

    @Override
    public void endDocument() throws SAXException {System.out.println("Конец обработки");}

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        value = value.concat(new String(ch, start, length).trim());
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (!value.isEmpty())System.out.println(tab+value);
        value="";
        tab=tab.substring(1);
        System.out.println(tab + "[/" + qName + "]");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print(tab + "[" + qName);
        for (int i = 0; i <attributes.getLength() ; i++) {
            String name = attributes.getLocalName(i);
            String value = attributes.getValue(i);
            System.out.print(" "+name+"="+value);
        }
        System.out.println("]");
        tab=tab+"\t";
        value="";
    }
}
