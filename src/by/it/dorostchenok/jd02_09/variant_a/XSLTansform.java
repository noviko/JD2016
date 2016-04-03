package by.it.dorostchenok.jd02_09.variant_a;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;

public class XSLTansform {

    private String xsltFilePath = "src/by/it/dorostchenok/jd02_09/variant_a/catalog_to_html.xslt";
    private String xmlFilePath = "src/by/it/dorostchenok/jd02_07_xml/catalog.xml";
    private File outputFile = new File("src/by/it/dorostchenok/jd02_09/variant_a/table.html");

    public void transform(){
        File transFile = new File(xsltFilePath);
        File xmlFile = new File(xmlFilePath);

        StreamSource streamSource = new StreamSource(transFile);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        Document document ;

        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse(xmlFile);
            Element root = document.getDocumentElement();

            Transformer transformer = TransformerFactory.newInstance().newTransformer(streamSource);
            transformer.transform(new DOMSource(root), new StreamResult(outputFile));
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
