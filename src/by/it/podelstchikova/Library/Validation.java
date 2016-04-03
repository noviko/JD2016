package by.it.podelstchikova.Library;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;


public class Validation {
    public static void main(String[] args) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String fName = "src/by/it/podelstchikova/Library/library.xml";
        String sName = "src/by/it/podelstchikova/Library/library.xsd";
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(sName);
        try {

            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(fName);
            validator.validate(source);
            System.out.println(fName + " валиден.");
        } catch (SAXException e) {
            System.err.print("Валидация " + fName + " не выполена: " + e.getMessage());
        } catch (IOException e) {
            System.err.print(fName + " не валиден:" + e.getMessage());
        }
    }
}
