package by.it.Baranova.JD03.JD03_03.DAO;

import by.it.Baranova.JD03.JD03_03.CN;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAO extends DAO implements InterfaceDAO<Orders> {

    @Override
    public List<Orders> getAll(String Where){
        List<Orders> orderslist=new ArrayList<>();
        String sql="SELECT * FROM Orders "+Where+" ;";

        try (Connection connection = DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            ResultSet rs=statement.executeQuery(sql);
            while (rs.next()){
                Orders orders = new Orders();
                orders.setIdOrder(rs.getInt("idOrder"));
                orders.setFKUser(rs.getInt("FKUser"));
                orders.setDaysQuantity(rs.getInt("DaysQuantity"));
                orders.setGuestQuantity(rs.getInt("GuestQuantity"));
                orders.setFKReservedRoom(rs.getInt("FKReservedRoom"));
                orderslist.add(orders);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    return orderslist;
    }

    @Override
    public Orders read(int id) {
        List<Orders> orders = getAll("WHERE idOrder=" + id + " LIMIT 0,1");
        if (orders.size() > 0) {
            return orders.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Orders orders){
        String sql = String.format(
                "insert INTO Orders(FKUser,DaysQuantity,GuestQuantity,FKReservedRoom)" +
                        " values(%d, %d, %d, %d);",
                orders.getFKUser(), orders.getDaysQuantity(), orders.getGuestQuantity(),orders.getFKReservedRoom()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean update(Orders orders){
        String sql=String.format(
        "UPDATE Orders SET FKUser = %d, DaysQuantity = %d ,GuestQuantity= %d, FKReservedRoom= %d, idOrder= %d WHERE Rooms.idOrder = %d",
                orders.getFKUser(), orders.getDaysQuantity(), orders.getGuestQuantity(),orders.getFKReservedRoom(), orders.getIdOrder(), orders.getIdOrder()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Orders orders) {
        String sql = String.format(
                "DELETE FROM Orders WHERE Orders.idOrder = %d;", orders.getIdOrder()
        );
        return (0 < executeUpdate(sql));
    }
}
