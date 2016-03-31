package by.it.Baranova.JD02.JD02_10;

import javax.xml.bind.annotation.*;

@XmlRootElement

public class Room {

    private String room_number;
    private Integer people_quantity;
    private String bed_size;
    private String seaview;
    private Integer floor;
    private Integer price;
    private String air_conditioner;

    public Room(){
        super();
    }

    public Room(String room_number, Integer people_quantity, String bed_size, String seaview, Integer floor, Integer price, String air_conditioner){
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
    public String getBed_size() {return bed_size;}
    public String getSeaview() {return seaview;}
    public Integer getFloor() {return floor;}
    public Integer getPrice() {return price;}

    public void setRoom_number(String room_number) {this.room_number = room_number;}
    public void setPeople_quantity(Integer people_quantity) {this.people_quantity = people_quantity;}
    public void setBed_size(String bed_size) {this.bed_size = bed_size;}
    public void setSeaview(String seaview) {this.seaview = seaview;}
    public void setFloor(Integer floor) {this.floor = floor;}
    public void setPrice(Integer price) {this.price = price;}
    public void setAir_conditioner(String air_conditioner) {this.air_conditioner = air_conditioner;}

    public String toString() {
        return "\nNumber: " + room_number + "\nPeople quantity: " + people_quantity + "\nBed size: " + bed_size
                + "\nSeaview: " + seaview   + "\nFloor: " + floor + "\nPrice: " +price+"\nAir conditioner: "+air_conditioner;
    }

}
