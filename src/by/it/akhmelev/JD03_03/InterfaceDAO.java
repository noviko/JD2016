package by.it.akhmelev.JD03_03;

import java.sql.SQLException;
import java.util.List;

interface InterfaceDAO<TYPE> {
    //CREATE,UPDATE,DELETE обновление сущности
    boolean set(TYPE entity);

    //READ - чтение всех элементов сущности
    List<TYPE> getAll();

    //READ чтение отдельной сущности
    TYPE getWhere(String expression) throws SQLException;


}
