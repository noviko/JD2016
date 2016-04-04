package by.it.telushko.jd02_07_project_plan;

import org.xml.sax.SAXException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Validator;
import javax.xml.XMLConstants;

import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import java.io.File;
import java.io.IOException;

public class Client_validation {
    public static void main (String[] args){
        String language= XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String filename="src/by/it/telushko/jd02_07_project_plan/client_xsd.xml";
        String schemaName="src/by/it/telushko/jd02_07_project_plan/clients.xsd";
        SchemaFactory factory=SchemaFactory.newInstance(language);
        File schemaLocation= new File(schemaName);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(filename);
            validator.validate(source);
            System.out.println("Валиден");
        }
        catch(SAXException e){System.out.println("Валидация не выполнена");}
        catch(IOException e){System.out.println("Не валиден");}
    }
}
