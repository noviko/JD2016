package by.it.novik.JD02_09;


import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Transformation {

    final static String way = System.getProperty("user.dir") + "/src/by/it/novik/JD02_09/";

    public static void main(String[] args) {
        String filename = way + "/project.xml/";

        try {
            TransformerFactory tf = TransformerFactory.newInstance();

            Transformer transformer = tf.newTransformer(new StreamSource(way + "transformation.xsl"));

            transformer.transform(new StreamSource(filename),
                    new StreamResult(way + "final.html"));

            System.out.println("Transform " + filename + " complete");

        } catch (TransformerException e) {

            System.out.println("Transformation failed for file " + filename);
        }
    }
}