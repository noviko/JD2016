package by.it.daylidovich.JD02_08.A;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Parser_SAX extends DefaultHandler {
    private String tab = "";
    private String value = "";
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Начало обработки.");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Конец обработки.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print(tab + "[" + qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            String name = attributes.getLocalName(i);
            String value = attributes.getValue(i);
            System.out.print(" " + name + "=" + value);
        }
        System.out.println("]");
        tab += "\t";
        value = "";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (!value.isEmpty())
            System.out.println(tab + value);
        tab = tab.substring(1);
        value = "";
        System.out.println(tab + "[/" + qName + "]");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        value = value + new String(ch, start, length).trim();
    }
}
