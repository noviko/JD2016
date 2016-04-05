package by.it.akhmelev.JD03_03;

import java.util.List;

interface InterfaceDAO<TYPE> {
    //CREATE Создание сущности
    boolean create(TYPE entity);

    //READ - чтение всех элементов сущности
    List<TYPE> getAllEntity();

    //READ чтение отдельной сущности
    TYPE getEntity(int id);

    //UPDATE - обновление отдельной сущности
    TYPE update(TYPE entity);

    //DELETE - удаление отдельной сущности
    boolean deleteID(int id);

    boolean delete(TYPE entity);

}
