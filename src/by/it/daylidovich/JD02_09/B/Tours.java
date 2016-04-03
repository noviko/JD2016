package by.it.daylidovich.JD02_09.B;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Tours {

    @XmlElement(name = "Tours")
    private  ArrayList<Tour> arrayList = new ArrayList<>();

    public Tours(){
        super();
    }

    public void setArrayList(ArrayList<Tour> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public String toString() {
        return "Tours{" +
                "arrayList=" + arrayList +
                '}';
    }

    public boolean add(Tour tour){
        return arrayList.add(tour);
    }
}
