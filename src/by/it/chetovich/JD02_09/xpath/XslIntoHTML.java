package by.it.chetovich.JD02_09.xpath;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * xsl into html
 */
public class XslIntoHTML {

    final static String root=System.getProperty("user.dir")+"/src/by/it/chetovich/JD02_09/xpath/";
    public static void main(String[ ] args) {
        String fileName=root+"hospital.xml";
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            // установка используемого XSL-преобразования
            Transformer transformer = tf.newTransformer(new StreamSource(root+"xslHospital.xsl"));
            // установка исходного XML-документа и конечного XML-файла
            transformer.transform(new StreamSource(fileName),
                    new StreamResult(root+"xpath.html"));
            System.out.println("Transform " + fileName + " complete");
        } catch(TransformerException e) {
            System.err.println("Impossible transform file " + fileName + " : " + e);
        }
    }
}
