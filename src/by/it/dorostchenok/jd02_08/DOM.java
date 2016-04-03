package by.it.dorostchenok.jd02_08;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOM {

    private Document parse(String xmlFilePath){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        Document document = null;
        File xmlFile = new File(xmlFilePath);

        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse(xmlFile);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return document;
    }

    public void printXML(String xmlFilePath){
        Document document = parse(xmlFilePath);

        Element root = document.getDocumentElement();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(root.getTagName());
        if (root.hasAttributes()){
            for (int j = 0; j < root.getAttributes().getLength(); j++){
                Node node = root.getAttributes().item(j);
                stringBuilder.append(" [" + node.getNodeName() + "]=" + node.getNodeValue());
            }
        }
        System.out.println(stringBuilder);

        for (int j = 0; j < root.getChildNodes().getLength(); j++){
            Node node = root.getChildNodes().item(j);
            printNode(node);
        }


    }

    private void printNode(Node node){

        StringBuilder stringBuilder = new StringBuilder();
        String nodeValue = node.getNodeValue();
        if (nodeValue != null){
            nodeValue = nodeValue.trim();
        } else{
            nodeValue = "";
        }
        StringBuilder nodeName = new StringBuilder(node.getNodeName());
        if (node.getNodeType() == Node.TEXT_NODE){
            nodeName = new StringBuilder();
        }
        if(node.getNodeType() == Node.TEXT_NODE && nodeValue.length() == 0)
           return;

        if (node.hasAttributes()){
            NamedNodeMap attributes = node.getAttributes();
            {
                for (int j = 0; j < attributes.getLength(); j++){
                    Node attr = attributes.item(j);
                    nodeName.append(" [" + attr.getNodeName() + "]=" + attr.getNodeValue());
                }
            }
        }
        stringBuilder.append(nodeName + " " + nodeValue);
        System.out.println(stringBuilder);

        for (int j = 0; j < node.getChildNodes().getLength(); j++){
            Node node1 = node.getChildNodes().item(j);
            printNode(node1);
        }
    }

}
