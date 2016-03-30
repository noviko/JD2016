package by.it.chetovich.JD02_10;

import by.it.chetovich.JD02_09.manual.Diagnoses;
import by.it.chetovich.JD02_09.manual.Prescribings;

import javax.xml.bind.annotation.XmlElement;

/**
 * Hospital for JSON
 */
public class HospitalForJSON {

    @XmlElement(name="diagnoses")
    private Diagnoses diagnoses;
    @XmlElement(name="prescribings")
    private Prescribings prescribings;
    public HospitalForJSON() {
        super();
    }

    public void setDiagnoses(Diagnoses diagnoses) {
        this.diagnoses = diagnoses;
    }

    public void setPrescribings(Prescribings prescribings) {
        this.prescribings = prescribings;
    }

   /* public Diagnoses getDiagnoses() {
        return diagnoses;
    }

    public Prescribings getPrescribings() {
        return prescribings;
    }*/


    @Override
    public String toString() {
        return "Diagnoses [" + diagnoses + "]"+'\n'+"Prescribings [" + prescribings + "]";
    }
}
