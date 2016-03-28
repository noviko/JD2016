package by.it.chetovich.JD02_09.manual;

import by.it.akhmelev.JD02_09.manual.Student;
import by.it.akhmelev.JD02_09.manual.Students;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * JaxB_toXML
 */
public class JaxB_toXML {

    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Hospital.class);
            Marshaller m = context.createMarshaller();
            Hospital st = new Hospital() { // анонимный класс
                {
                    // добавление первого студента
                    Diagnoses diagnoses = new Diagnoses() {
                        {
                            Diagnosis.Drugs drugs = new Diagnosis.Drugs("paracetamol", "1pill3times");
                            Diagnosis diagnosis = new Diagnosis("flu", "influenza", "7", drugs);
                            this.add(diagnosis);

                            drugs = new Diagnosis.Drugs("arpetol","2pills3times");
                            diagnosis = new Diagnosis("angina", "angina", "5", drugs);
                            this.add(diagnosis);
                        }

                    };
                    Prescribings prescribings = new Prescribings(){
                        {
                            Prescribing prescribing = new Prescribing("massage", "employee","physiotherapy","100");
                            this.add(prescribing);

                            prescribing = new Prescribing("quartz", "employee","physiotherapy","50");
                            this.add(prescribing);

                            prescribing = new Prescribing("injection", "patient","medication","80");
                            this.add(prescribing);
                        }
                    };
                    this.setDiagnoses(diagnoses);
                    this.setPrescribings(prescribings);
                }
            };
            m.marshal(st, new FileOutputStream(System.getProperty("user.dir")+"/src/by/it/chetovich/JD02_09/manual/xml_01.xml"));
            System.out.println("XML-файл создан");
            m.marshal(st, System.out); // копия на консоль
        } catch (FileNotFoundException e) {
            System.out.println("XML-файл не может быть создан: " + e);
        } catch (JAXBException e) {
            System.out.println("JAXB-контекст ошибочен " + e);
        }
    }
}
