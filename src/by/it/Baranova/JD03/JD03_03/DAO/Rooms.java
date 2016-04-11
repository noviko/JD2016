package by.it.Baranova.JD03.JD03_03.DAO;


import java.sql.SQLException;

public class Rooms {

    private int idRooms;
    private String RoomNumber;
    private int GuestQuantity;
    private int FKFirstBedSize;
    private int FKSecondBedSize;
    private int FKSeaview;
    private int Floor;
    private int Price;
    private int FKOrderNumber;

    public Rooms(){
    }

    public Rooms(String roomNumber, int guestQuantity, int FKFirstBedSize, int FKSecondBedSize, int FKSeaview, int floor, int price) {
        this.RoomNumber = roomNumber;
        this.GuestQuantity = guestQuantity;
        this.FKFirstBedSize = FKFirstBedSize;
        this.FKSecondBedSize = FKSecondBedSize;
        this.FKSeaview = FKSeaview;
        this.Floor = floor;
        this.Price = price;
    }

    public int getIdRooms() {return idRooms;}
    public String getRoomNumber() {return RoomNumber;}
    public int getGuestQuantity() {return GuestQuantity;}
    public int getFKFirstBedSize() {return FKFirstBedSize;}
    public int getFKSecondBedSize() {return FKSecondBedSize;}
    public int getFKSeaview() {return FKSeaview;}
    public int getFloor() {return Floor;}
    public int getPrice() {return Price;}
    public int getFKOrderNumber() {return FKOrderNumber;}

    public void setIdRooms(int idRooms) {this.idRooms = idRooms;}
    public void setRoomNumber(String roomNumber) {RoomNumber = roomNumber;}
    public void setGuestQuantity(int guestQuantity) {GuestQuantity = guestQuantity;}
    public void setFKFirstBedSize(int FKFirstBedSize) {this.FKFirstBedSize = FKFirstBedSize;}
    public void setFKSecondBedSize(int FKSecondBedSize) {this.FKSecondBedSize = FKSecondBedSize;}
    public void setFKSeaview(int FKSeaview) {this.FKSeaview = FKSeaview;}
    public void setFloor(int floor) {Floor = floor;}
    public void setPrice(int price) {Price = price;}
    public void setFKOrderNumber(int FKOrderNumber) {this.FKOrderNumber = FKOrderNumber;}


    @Override
    public String toString() {
        String res="";
        try {
            res="Room{" +
                    "id=" + idRooms +
                    ", Number of room='" + RoomNumber + '\'' +
                    ", guestquantity='" + GuestQuantity + '\'' +
                    ", first bed='"+new BedSizeDAO().getBedSize(FKFirstBedSize)+'\''+
                    ", second bed='"+new BedSizeDAO().getBedSize(FKSecondBedSize)+'\''+
                    ", seaview='"+new SeaviewDAO().getSeaview(FKSeaview)+'\''+
                    ", floor='" + Floor + '\'' +
                    ", price=" + Price +'\'' +
                    ", number of order="+new OrdersDAO().read(FKOrderNumber)+
                    '}';
        } catch (SQLException e) {
            res=e.toString();
        }
        return res;
    }
}
