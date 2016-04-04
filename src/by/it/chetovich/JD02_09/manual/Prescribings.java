package by.it.chetovich.JD02_09.manual;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Prescribings
 */
@XmlRootElement

public class Prescribings {

    @XmlElement(name="prescribing")
    private ArrayList<Prescribing> list = new ArrayList<>();
    public Prescribings() {
        super();
    }
    public void setList(ArrayList<Prescribing> list) {
        this.list = list;
    }
    public boolean add(Prescribing p) {
        return list.add(p);
    }
    @Override
    public String toString() {
        return "Prescribings [list=" + list + "]";
    }
}
