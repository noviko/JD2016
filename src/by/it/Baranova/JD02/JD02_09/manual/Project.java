package by.it.Baranova.JD02.JD02_09.manual;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlRootElement

public class Project {

    @XmlElement (name="room")
    private ArrayList<Room> list=new ArrayList<>();
    public Project(){super();}

    public void setList(ArrayList<Room> list) {this.list = list;}

    public boolean addList(Room room){return list.add(room);}

    @Override
    public String toString(){return "Rooms [list="+list+"]";}
}
