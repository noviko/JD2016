package by.it.chetovich.JD02_09.manual;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * hospital
 */
@XmlRootElement

public class Hospital {

    @XmlElement(name="diagnoses")
    private Diagnoses diagnoses;
    @XmlElement(name="prescribings")
    private Prescribings prescribings;
    /*public Hospital() {
        super();
    }*/

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
