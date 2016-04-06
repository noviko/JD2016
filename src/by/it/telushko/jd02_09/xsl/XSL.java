package by.it.telushko.jd02_09.xsl;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XSL {
    final static String root="src/by/it/telushko/JD02_09/xsl/";
    public static void main(String[ ] args) {
        String fileName=root+"clients.xml";
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer(new StreamSource(root+"clients.xsl"));
            transformer.transform(new StreamSource(root+"clients.xml"),
                    new StreamResult(root+"clients.html"));
            System.out.println("Преобразование " + fileName + " выполнено");
        } catch(TransformerException e) {
            System.err.println("Преобразование невозможно" + fileName + " : " + e);
        }
    }
}
