package by.it.chetovich.JD03_02.ConsoleAppCRUD;

import by.it.chetovich.JD03_02.CRUD_Realization.CRUD_operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */
public class Utils {

    public static String stin ()  {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        try {
            s = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;

    }

    public static void chooseMenu (String enter){

        switch (enter) {
            case "1":
                CRUD_operations.selectCities();
                break;
            case "2":
                System.out.println("Введите название города, который хотите добавить:");
                String newCity = Utils.stin();
                CRUD_operations.insertCities(newCity);
                System.out.println("Город успешно добавлен.");
                break;
            case "3":
                System.out.println("Введите название столбца, по которому хотите выбрать: id_city или city");
                String columnName = Utils.stin();
                System.out.println("Введите слово, которое хотите искать: id столбца или название города:");
                String word = Utils.stin();
                CRUD_operations.selectCitiesWhere(columnName, word);
                System.out.println("В базе данных нет такого поля.");
                break;
            case "4":
                System.out.println("Введите номер города, который хотите изменить");
                String id = Utils.stin();
                System.out.println("Введите новое название");
                String updatedCity = Utils.stin();
                CRUD_operations.updateCities(id, updatedCity);
                System.out.println("Запись успешно изменена");
                break;
            case "5":
                System.out.println("Введите номер города, который хотите удалить");
                id = Utils.stin();
                CRUD_operations.deleteCities(id);
                System.out.println("Город удалён");
                break;
            default:
                System.out.println("Такого номера нет в меню");
        }
    }
}
