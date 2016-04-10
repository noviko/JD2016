package by.it.daylidovich.JD03_03.DAO;

import java.sql.SQLException;
import java.util.List;

public interface IDAO<TYPE> {
        List<TYPE> getAll(String WhereAndOrder) throws SQLException;
        TYPE read(int id);
        boolean create(TYPE type);
        boolean update(TYPE type);
        boolean delete(TYPE type);
}
