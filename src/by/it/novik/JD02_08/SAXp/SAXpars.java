package by.it.novik.JD02_08.SAXp;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SAXpars extends DefaultHandler {
    public static void main(String[] args) {

        try {
            String way = System.getProperty("user.dir") + "/src/by/it/novik/";
            String filename = way + "/JD02_07/project_connected_XSD.xml/";

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            SAXpars sx = new SAXpars();
            parser.parse(new File(filename), sx );

        } catch (Exception e) {
            System.out.println("Failed " + e);
        }

    }


    private String space = "";
    private String value;
    private String name;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Parsing started");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Parsing ended");
    }

    @Override
    public void startElement(String s, String s1, String qName, Attributes attributes) throws SAXException {

        System.out.print(space + "[" + qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            name = attributes.getLocalName(i);
            value = attributes.getValue(i);
            System.out.print(" " + name + "=" + value);
        }
        System.out.println("]");
        space = '\t' + space;
        value = "";

    }

    @Override
    public void endElement(String s, String s1, String qName) throws SAXException {

        if(!value.isEmpty())
            System.out.println(space + value);
            value = "";
            space = space.substring(1);
            System.out.println(space + "[/" + qName + "]");

    }

    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        value = value.concat(new String(chars, start, length));
    }

}
