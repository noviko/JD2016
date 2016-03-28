package by.it.chetovich.JD02_09.manual;

import by.it.akhmelev.JD02_09.manual.Student;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * diagnoses
 */
@XmlRootElement

public class Diagnoses {

    @XmlElement(name="diagnosis")
    private ArrayList<Diagnosis> list = new ArrayList<>();
    public Diagnoses() {
        super();
    }
    public void setList(ArrayList<Diagnosis> list) {
        this.list = list;
    }
    public boolean add(Diagnosis diagnosis) {
        return list.add(diagnosis);
    }
    @Override
    public String toString() {
        return "Diagnoses [list=" + list + "]";
    }
}
