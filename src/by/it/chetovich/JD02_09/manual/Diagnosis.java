package by.it.chetovich.JD02_09.manual;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Diagnosis
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)     // FIELD - все поля в XML
@XmlType(name = "Diagnosis", propOrder = {  // PROPERTY - только  с геттерами и сеттерами
        "name",                           // PUBLIC_MEMBER - только public
        "drugs",                       // NONE - ни одно
        "recoveryTime"
})

public class Diagnosis {

    @XmlAttribute(required = true) //опишем логин как аттрибут
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class) //тип адаптера
    @XmlID                         //и ключевой (уникальный)
    private String id;
    @XmlElement(required = true)
    private String name;
    @XmlElement(required = true)
    private String recoveryTime;
    @XmlElement(required = true)
    private Drugs drugs = new Drugs();

    public Diagnosis() {
    } // необходим для маршаллизации/демаршалиизации XML

    public Diagnosis(String id, String name, String recoveryTime, Drugs drugs) {
        this.id = id;
        this.name = name;
        this.recoveryTime = recoveryTime;
        this.drugs = drugs;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRecoveryTime() {
        return recoveryTime;
    }

    public Drugs getDrugs() {
        return drugs;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRecoveryTime(String recoveryTime) {
        this.recoveryTime = recoveryTime;
    }

    public void setAddress(Drugs drugs) {
        this.drugs = drugs;
    }

    public String toString() {
        return "\nID: " + id + "\nName: " + name + "\nRecovery Time: " + recoveryTime
                + drugs.toString();
    }


    @XmlRootElement
    @XmlType(name = " drugs ", propOrder = {
            "name",
            "dosage"
    })
    public static class Drugs {
        private String name;
        private String dosage;

        //конструкторы
        public Drugs() {// необходим для маршаллизации/демаршалиизации XML
        }

        public Drugs(String name, String dosage) {
            this.name = name;
            this.dosage = dosage;
        }

        public String getName() {
            return name;
        }

        public String getDosage() {
            return dosage;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDosage(String dosage) {
            this.dosage = dosage;
        }

        public String toString (){
            return "\nDrugs: "+name+", dosage "+dosage;
        }
    }
}