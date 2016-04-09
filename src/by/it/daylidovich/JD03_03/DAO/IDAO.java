package by.it.daylidovich.JD03_03.DAO;

import java.util.List;

public interface IDAO<TYPE> {
        TYPE read(int id);
        boolean create(TYPE entity);
        boolean update(TYPE entity);
        boolean delete(TYPE entity);
        List<TYPE> getAll(String WhereAndOrder);
}
