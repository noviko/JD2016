package by.it.Baranova.JD03.JD03_03.DAO;


import java.sql.SQLException;

public class Orders {

    private int idOrder;
    private int FKUser;
    private int DaysQuantity;
    private int GuestQuantity;
    private int FKReservedRoom;

    public Orders(){
    }

    public Orders(int idorder, int fkUser, int daysQuantity, int guestQuantity, int fkReservedRoom) {
        this.idOrder = idorder;
        this.FKUser=fkUser;
        this.DaysQuantity=daysQuantity;
        this.GuestQuantity = guestQuantity;
    }

    public int getIdOrder() {return idOrder;}
    public int getFKUser() {return FKUser;}
    public int getDaysQuantity() {return DaysQuantity;}
    public int getGuestQuantity() {return GuestQuantity;}
    public int getFKReservedRoom() {return FKReservedRoom;}

    public void setIdOrder(int idOrder) {this.idOrder = idOrder;}
    public void setFKUser(int FKUser) {this.FKUser = FKUser;}
    public void setDaysQuantity(int daysQuantity) {DaysQuantity = daysQuantity;}
    public void setGuestQuantity(int guestQuantity) {GuestQuantity = guestQuantity;}
    public void setFKReservedRoom(int FKReservedRoom) {this.FKReservedRoom = FKReservedRoom;}

    @Override
    public String toString() {
        String res="";
            res="Order{" +
                    "idOrder=" + idOrder +
                    ", User='" + new UsersDAO().read(FKUser) + '\'' +
                    ", days quantity='" + DaysQuantity + '\'' +
                    ", guest quantity='" + GuestQuantity + '\'' +
                    ", reserved room='"+new RoomsDAO().read(FKReservedRoom)+'\''+
                    '}';
        return res;
    }
}
