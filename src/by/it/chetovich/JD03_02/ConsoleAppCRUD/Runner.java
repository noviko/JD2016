package by.it.chetovich.JD03_02.ConsoleAppCRUD;

import by.it.chetovich.JD03_02.CRUD_Realization.CRUD_operations;

/**
 * Main
 */
public class Runner {

    public static void main(String[] args) {

        String enter;
        String line = "Выбирите номер действия из предложенного списка для работы с таблицей Cities: \n " +
                "1 - Показать таблицу \n 2 - Добавить запись \n 3 - Выбрать запись \n 4 - Изменить запись \n " +
                "5 - Удалить запись \n Для выхода нажмите enter";
        System.out.println(line);
        while (!(enter = Utils.stin()).isEmpty()) {

            Utils.chooseMenu(enter);
            System.out.println("\n"+line);
        }
    }
}
