package by.it.chetovich.JD03_03;

import java.util.HashMap;

/**
 * Interface DAO
 */
public interface InterfaceDAO <T> {

    boolean create (T t);
    boolean update (T t);
    boolean delete (T t);
    T read (int id);
    HashMap<Integer, T> getAll (String where);
    void showTable();
}
