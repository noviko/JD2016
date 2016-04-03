package by.it.dorostchenok.jd02_08;

public class Main {



    public static void main(String[] args) {
        String catalogXML = "src/by/it/dorostchenok/jd02_07_xml/catalog.xml";
        DOM dom = new DOM();
        //dom.printXML(catalogXML);
        StAX stax = new StAX();
        stax.printXML(catalogXML);
    }
}
