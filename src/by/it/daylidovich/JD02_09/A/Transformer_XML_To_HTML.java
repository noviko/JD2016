package by.it.daylidovich.JD02_09.A;

import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;


public class Transformer_XML_To_HTML {
    public static void main(String[] args) {
        try{
            TransformerFactory factory = TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = factory.newTransformer(new StreamSource("src\\by\\it\\daylidovich\\JD02_09\\A\\XML.xsl"));
            transformer.transform(new StreamSource("src\\by\\it\\daylidovich\\JD02_07\\A\\XML.xml"), new StreamResult("src\\by\\it\\daylidovich\\JD02_09\\A\\XML.html"));
            System.out.println("Complete");
        } catch (TransformerException e) {
            System.out.println(e.toString());
        }
    }
}
