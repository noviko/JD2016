package by.it.Baranova.JD02.JD02_10.C;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "room", propOrder = {
        "room_number",
        "people_quantity",
        "bed_size",
        "seaview",
        "floor",
        "price",
        "air_conditioner"
})

public class Room {
    @XmlElement (required = true)
    private String room_number;



    @XmlElement(required = true)
    private Integer people_quantity;
    @XmlElement(required = true)
    private Bed_size bed_size=new Bed_size();


    @XmlElement (required = true)
    private String seaview;
    @XmlElement (required = true)
    private Integer floor;
    @XmlElement (required = true)
    private Integer price;
    @XmlElement (required = true)
    private String air_conditioner;

    public Room(){
        super();
    }

    public Room(String room_number,Integer people_quantity,Bed_size bed_size,String seaview,Integer floor,Integer price,String air_conditioner){
        this.room_number=room_number;
        this.people_quantity=people_quantity;
        this.bed_size=bed_size;
        this.seaview=seaview;
        this.floor=floor;
        this.price=price;
        this.air_conditioner=air_conditioner;
    }

    public String getAir_conditioner() {return air_conditioner;}
    public String getRoom_number() {return room_number;}
    public Integer getPeople_quantity() {return people_quantity;}
    public Bed_size getBed_size() {return bed_size;}
    public String getSeaview() {return seaview;}
    public Integer getFloor() {return floor;}
    public Integer getPrice() {return price;}

    public void setRoom_number(String room_number) {this.room_number = room_number;}
    public void setPeople_quantity(Integer people_quantity) {this.people_quantity = people_quantity;}
    public void setBed_size(Bed_size bed_size) {this.bed_size = bed_size;}
    public void setSeaview(String seaview) {this.seaview = seaview;}
    public void setFloor(Integer floor) {this.floor = floor;}
    public void setPrice(Integer price) {this.price = price;}
    public void setAir_conditioner(String air_conditioner) {this.air_conditioner = air_conditioner;}

    public String toString() {
        return "\nNumber: " + room_number + "\nPeople quantity: " + people_quantity + "\nBed size: " + bed_size.toString()
                + "\nSeaview: " + seaview   + "\nFloor: " + floor + "\nPrice: " +price+"\nAir conditioner: "+air_conditioner;
    }

    @XmlRootElement
    @XmlType (name="Bed_size", propOrder={
            "first_Bed_size",
            "second_Bed_size"
    })
    public static class Bed_size {

        private String first_Bed_size;
        private String second_Bed_size;

        public Bed_size(){}

        public Bed_size(String first_Bed_size,String second_Bed_size){
            this.first_Bed_size=first_Bed_size;
            this.second_Bed_size=second_Bed_size;
        }

        public String getFirst_Bed_size() {return first_Bed_size;}
        public String getSecond_Bed_size() {return second_Bed_size;}

        public void setSecond_Bed_size(String second_Bed_size) {this.second_Bed_size = second_Bed_size;}
        public void setFirst_Bed_size(String first_Bed_size) {this.first_Bed_size = first_Bed_size;}

        public String toString() {
            return "\nFirst bed size :" + first_Bed_size
                    + "\n\tSecond bed size: " + second_Bed_size + "\n";
        }
    }
}
