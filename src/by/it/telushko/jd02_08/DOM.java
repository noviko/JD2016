package by.it.telushko.jd02_08;


import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class DOM {
    public static void main(String[] args) {
        String path = "src/by/it/telushko/JD02_07_project_plan/client_xsd.xml";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(path);
            Element el = doc.getDocumentElement();
            printDom("", el);
        } catch (Exception e) {
            System.out.println("Ошибка" + e.toString());
        }
    }

    private static void printDom(String prefix, Node node) {
        String text = node.getNodeValue();
        if (text != null) {
            System.out.println(prefix + text.trim());
        }

        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            String attr="";
            if(children.item(i).hasAttributes()){
                NamedNodeMap attributesMap=children.item(i).getAttributes();
                for (int j=0;j<attributesMap.getLength();j++){
                    attr=attr.concat(" ").concat(attributesMap.item(j).getNodeName()).concat("=").concat(attributesMap.item(j).getNodeValue());
                }
            }
            printDom(prefix + node.getNodeName() + attr+" > ", children.item(i));
        }
    }
}
