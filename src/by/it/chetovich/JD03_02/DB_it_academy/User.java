package by.it.chetovich.JD03_02.DB_it_academy;

import java.sql.SQLException;
import java.sql.Timestamp;
import by.it.chetovich.JD03_03.RoleDAO;


/**
 * for table users
 */
public class User {

    String name;
    String surname;
    String login;
    String password;
    Timestamp birthdate;
    int role;
    String email;
    int id;

    public User (){

    }

    public User(String name, String surname, String login, String password, Timestamp birthdate, int role, String email) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.birthdate = birthdate;
        this.role = role;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Timestamp getBirthdate() {
        return birthdate;
    }

    public int getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirthdate(Timestamp birthdate) {
        this.birthdate = birthdate;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        String res;
        try {

            res="User{" +
                    "id = " + id +
                    ", name = " + name +
                    ", surname = " + surname +
                    ", birthdate  = " + birthdate +
                    ", login = " + login +
                    ", password = " + password +
                    ", email = " + email +
                    ", id_role = " + new RoleDAO().getRole(role) +
                    '}';
        } catch (SQLException e) {
            res=e.toString();
        }
        return res;
    }
}
