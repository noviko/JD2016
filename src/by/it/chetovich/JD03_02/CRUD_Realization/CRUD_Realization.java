package by.it.chetovich.JD03_02.CRUD_Realization;


/**
 * Realization of CRUD operations for users and role tables in DB it-academy
 */
public class CRUD_Realization {

    public static void main(String[] args) {

      /*  //table users
        //вывод всех записей
        CRUD_operations.selectUsers();
        //добавление записи
        CRUD_operations.insertUsers("Kate","Tomson","tomson","yultos","1985-10-10","1","tomson@gmail.com");
        //вывод добавленной записи
        CRUD_operations.selectUsersWhere("surname", "Tomson");
        //обновление записи
        CRUD_operations.updateUsers("2","Mark", null,null,null,null,null, null );
        //вывод обновлёееой записи
        CRUD_operations.selectUsersWhere("name", "Mark");
        //удаление записи
        CRUD_operations.deleteUsers("surname", "Tomson");
        //вывод оставшихся записей
        CRUD_operations.selectUsers();

        //table role
        //вывод всех записей
        CRUD_operations.selectRole();
        //добавление записи
        CRUD_operations.insertRole("owner");
        //вывод добавленной записи
        CRUD_operations.selectRoleWhere("role_type", "owner");
        //обновление записи
        CRUD_operations.updateRole("2", "admin");
        //вывод обновлёееой записи
        CRUD_operations.selectRoleWhere("id_role", "2");
        //удаление записи
        CRUD_operations.deleteRole("3");
        //вывод оставшихся записей
        CRUD_operations.selectRole();*/

        //table cities
        //вывод всех записей
        CRUD_operations.selectCities();
        //добавление записи
        CRUD_operations.insertCities("Paris");
        //вывод добавленной записи
        CRUD_operations.selectCitiesWhere("city", "London");
        //обновление записи
        CRUD_operations.updateCities("3", "New-York");
        //вывод обновлёееой записи
        CRUD_operations.selectCitiesWhere("id_city", "3");
        //удаление записи
        CRUD_operations.deleteCities("5");
        //вывод оставшихся записей
        CRUD_operations.selectCities();
    }
}
