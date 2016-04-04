package by.it.knyazev.JD02.less_07;

import jdk.internal.org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

/**
 * Created by Mac on 25.03.16.
 */
public class Main {
    public static void main(String[ ] args) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String fileName = "src/by/it/knyazev/JD02/less_07/index.xml";
        String schemaName = "src/by/it/knyazev/JD02/less_07/index.xsd";
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(fileName);
            validator.validate(source);
            System.out.println(fileName + " valid");
        } catch (Exception e) {
            System.err.print("Error");
        }
    }
}
