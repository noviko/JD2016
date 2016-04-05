package by.it.akhmelev.JD03_03;

import java.util.List;

class UsersDAO implements InterfaceDAO<Users>{
    private UsersDAO dao; //синглтон для DAO

    UsersDAO getDAO() {   //метод, который создает DAO или возвращает существующий экземпляр
        if (dao == null) {
            dao = new UsersDAO();
        }
        return dao;
    }


    @Override
    public boolean create(Users entity) {
        return false;
    }

    @Override
    public List<Users> getAllEntity() {
        return null;
    }


    @Override
    public Users getEntity(int id) {
        return null;
    }

    @Override
    public Users update(Users entity) {
        return null;
    }

    @Override
    public boolean deleteID(int id) {
        return false;
    }

    @Override
    public boolean delete(Users entity) {
        return false;
    }
}
