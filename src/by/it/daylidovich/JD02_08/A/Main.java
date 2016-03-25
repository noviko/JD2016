package by.it.daylidovich.JD02_08.A;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            Parser_SAX implementation = new Parser_SAX();
            parser.parse(new File("src\\by\\it\\daylidovich\\JD02_07\\A\\XML.xml"), implementation);
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
