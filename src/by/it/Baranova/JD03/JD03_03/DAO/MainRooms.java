package by.it.Baranova.JD03.JD03_03.DAO;

import java.sql.SQLException;
import java.util.List;

public class MainRooms {

    static void showRooms(){
        //покажем все, что есть в таблице пользователей
        System.out.println("\nТаблица комнат:");
        List<Rooms> rooms=new RoomsDAO().getAll("");
        for (Rooms each:rooms) System.out.println(each);

    }

    public static void main(String[] args) throws SQLException {
        //инициализация работы с базой
        DAO.getDAO();
        RoomsDAO roomsDAO = new RoomsDAO();

        System.out.println("Справочник Seaview");
        SeaviewDAO seaviewDAO=new SeaviewDAO();
        for (int id = 1; id < 3; id++) {
            String seaview = seaviewDAO.getSeaview(id);
            System.out.println(id + ": " + seaview);
        }
        System.out.println();

        System.out.println("Справочник BedSize");
        BedSizeDAO bedSizeDAO=new BedSizeDAO();
        for (int id = 1; id < 7; id++) {
            String bedsize = bedSizeDAO.getBedSize(id);
            System.out.println(id + ": " + bedsize);
        }

        showRooms();

        Rooms rooms=new Rooms("R07",1,1,6,2,3,65);
        rooms.setIdRooms(7);
        rooms.setFKOrderNumber(0);

        //добавим комнату
        if (roomsDAO.create(rooms)) System.out.println("\nДобавлена:" + rooms);
        showRooms();

        //извлечем и обновим комнату
        rooms = roomsDAO.getAll("WHERE idRooms>6").get(0);
        rooms.setPrice(70);
        if (roomsDAO.update(rooms)) System.out.println("\nИзменено:" + rooms);
        showRooms();

        //удалим пользователя
        if (roomsDAO.delete(rooms)) System.out.println("\nУдален:" + rooms);
        showRooms();
    }
}
