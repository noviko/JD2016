package by.it.zhuravlyov.JD02_09;

        import javax.xml.transform.Transformer;
        import javax.xml.transform.TransformerException;
        import javax.xml.transform.TransformerFactory;
        import javax.xml.transform.stream.StreamResult;
        import javax.xml.transform.stream.StreamSource;

/**
 * Created by user_2 on 28.03.2016.
 */
public class xml_html {
    final static String root1 = "src/by/it/zhuravlyov/JD02_09/";
    final static String root2 = "src/by/it/zhuravlyov/JD02_07/";

    public static void main(String[] args) {
        String fileName = root2 + "car_rental.xml";
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            // установка используемого XSL-преобразования
            Transformer transformer = tf.newTransformer(new StreamSource(root1 + "dop.xsl"));
            // установка исходного XML-документа и конечного XML-файла
            transformer.transform(new StreamSource(root2 + "car_rental.xml"),
                    new StreamResult(root1 + "car_rental.html"));
            System.out.println("Transform " + fileName + " complete");
        } catch (TransformerException e) {
            System.err.println("Impossible transform file " + fileName + " : " + e);

        }
    }
}
