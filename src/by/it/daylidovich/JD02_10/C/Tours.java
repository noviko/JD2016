package by.it.daylidovich.JD02_10.C;

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
        String out = "";
        for (Tour tour: arrayList)
        out += tour.toString() + "\n";
        return out;
    }

    public boolean add(Tour tour){
        return arrayList.add(tour);
    }
}
