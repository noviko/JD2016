package by.it.chetovich.JD03_02.DB_it_academy;

import java.util.Date;

/**
 * for table users
 */
public class User {

    String name;
    String surname;
    String login;
    String password;
    Date birthdate;
    int role;
    String email;

    public User(String name, String surname, String login, String password, Date birthdate, int role, String email) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.birthdate = birthdate;
        this.role = role;
        this.email = email;
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

    public Date getBirthdate() {
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

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
