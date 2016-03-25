package by.it.knyazev.JD02.less_08;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

/**
 * Created by Mac on 25.03.16.
 */
public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        String filename = "src/by/it/knyazev/JD02/less_07/index.xml";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse(filename);

        Element el = doc.getDocumentElement();
        
        printDom("", el);
    }

    public static void printDom(String prefix,  Node node) {
        String text = node.getNodeName();

        if(text!=null){
            System.out.println(prefix + text.trim());
        }

        NodeList body = node.getChildNodes();

        for (int i = 0; i < body.getLength(); i++) {
            printDom(prefix+node.getNodeName() + " > ", body.item(i) );
        }
    }
}
