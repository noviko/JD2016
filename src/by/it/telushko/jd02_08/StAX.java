package by.it.telushko.jd02_08;



import javax.xml.namespace.QName;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;

public class StAX {
    static String tab="";
    public static void main (String[] args){
        try{
            String path="src/by/it/telushko/JD02_07_project_plan/client_xsd.xml";
            FileInputStream input =new FileInputStream(path);
            XMLInputFactory inputFactory=XMLInputFactory.newInstance();
            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
            String el="";
            while (reader.hasNext()){
                int type=reader.next();
                switch (type){
                    case XMLStreamConstants.START_ELEMENT:{
                        System.out.print(tab+"["+reader.getLocalName());
                        for(int i = 0, n = reader.getAttributeCount(); i < n; ++i) {
                            QName name = reader.getAttributeName(i);
                            String value = reader.getAttributeValue(i);
                            System.out.print(" "+name + "=" + value);
                        }

                        System.out.println("]");
                        tab=tab+"\t";
                        break;
                    }
                    case XMLStreamConstants.CHARACTERS:{
                        el=el.concat(reader.getText().trim());
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT:{
                        if (!el.isEmpty())System.out.println(tab+el);
                        tab=tab.substring(1);
                        el="";
                        System.out.println(tab+"[/"+reader.getLocalName()+"]");
                        break;
                    }
                }
            }

        }
        catch (Exception e){System.out.println("Ошибка" +e.toString());}
    }
}
