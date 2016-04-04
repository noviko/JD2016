package by.it.Baranova.JD02.JD02_09.xpath;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;


public class XSL {
    final static String root=System.getProperty("user.dir")+"/src/by/it/Baranova/JD02/JD02_09/xpath/";
    public static void main(String[] args){
        String filename=root+"Project.xml";
        try {
            TransformerFactory tf=TransformerFactory.newInstance();
            Transformer transformer=tf.newTransformer(new StreamSource(root+"Project.xsl"));
            transformer.transform(new StreamSource(root+"Project.xml"),new StreamResult(root+"Project.html"));
            System.out.println("Transform "+filename+" complete");
        } catch (TransformerException e){
            System.err.println("Impossible transform file "+filename+":"+e);
        }

    }

}
