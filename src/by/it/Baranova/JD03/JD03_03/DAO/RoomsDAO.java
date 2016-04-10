package by.it.Baranova.JD03.JD03_03.DAO;

import by.it.Baranova.JD03.JD03_03.CN;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomsDAO extends DAO implements InterfaceDAO<Rooms> {

    @Override
    public List<Rooms> getAll(String Where){
        List<Rooms> roomslist=new ArrayList<>();
        String sql="SELECT * FROM Rooms "+Where+" ;";
        try (Connection connection = DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            ResultSet rs=statement.executeQuery(sql);
            while (rs.next()){
                Rooms rooms = new Rooms();
                rooms.setIdRooms(rs.getInt("idRooms"));
                rooms.setRoomNumber(rs.getString("RoomNumber"));
                rooms.setFKFirstBedSize(rs.getInt("FKFirstBedSize"));
                rooms.setFKSecondBedSize(rs.getInt("FKSecondBedSize"));
                rooms.setFKSeaview(rs.getInt("FKSeaview"));
                rooms.setFloor(rs.getInt("Floor"));
                rooms.setPrice(rs.getInt("Price"));
                rooms.setGuestQuantity(rs.getInt("GuestQuantity"));
                rooms.setFKOrderNumber(rs.getInt("FKOrderNumber"));
                roomslist.add(rooms);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    return roomslist;
    }

    @Override
    public Rooms read(int id) {
        List<Rooms> rooms = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (rooms.size() > 0) {
            return rooms.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Rooms rooms){
        String sql = String.format(
                "insert INTO Rooms(RoomNumber,GuestQuantity,FKFirstBedSize,FKSecondBedSize,FKSeaview,Floor,Price,FKOrderNumber)" +
                        " values('%s', %d, %d, %d, %d, %d, %d, %d);",
                rooms.getRoomNumber(), rooms.getGuestQuantity(), rooms.getFKFirstBedSize(),rooms.getFKSecondBedSize(), rooms.getFKSeaview(), rooms.getFloor(), rooms.getPrice(),rooms.getFKOrderNumber()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean update(Rooms rooms){
        String sql=String.format(
        "UPDATE Rooms SET RoomNumber = '%s', GuestQuantity = %d ,FKFirstBedSize= %d, FKSecondBedSize= %d, FKSeaview= %d, Floor = %d, Price = %d, FKOrderNumber=%d WHERE Rooms.idRooms = %d",
                rooms.getRoomNumber(), rooms.getGuestQuantity(), rooms.getFKFirstBedSize(),rooms.getFKSecondBedSize(), rooms.getFKSeaview(), rooms.getFloor(), rooms.getPrice(),rooms.getFKOrderNumber(), rooms.getIdRooms()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Rooms rooms) {
        String sql = String.format(
                "DELETE FROM Rooms WHERE Rooms.idRooms = %d;", rooms.getIdRooms()
        );
        return (0 < executeUpdate(sql));
    }
}
