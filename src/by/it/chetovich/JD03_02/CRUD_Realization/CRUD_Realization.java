package by.it.chetovich.JD03_02.CRUD_Realization;


import by.it.chetovich.JD03_02.CRUD_Realization.CRUD_operations;

import java.sql.ResultSet;

/**
 * Realization of CRUD operations for all tables in DB it-academy
 */
public class CRUD_Realization {

    public static void main(String[] args) {

        //table users
        //вывод всех записей
        ResultSet resultSet = CRUD_operations.selectAll("users");
        //добавление записи
        //CRUD_operations.insertUsers("Kate","Tomson","tomson","yultos","1985-10-10","1","tomson@gmail.com");
        //вывод добавленной записи
        //CRUD_operations.selectAllWhere("users","surname","Tomson");
    }
}
