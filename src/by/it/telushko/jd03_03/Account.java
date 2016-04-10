package by.it.telushko.jd03_03;

import java.sql.SQLException;

/**
 * Created by Владимир on 10.04.2016.
 */
public class Account {

    public Account() {
    }

    public Account(String name,String login,String password){
        this.name=name;
        this.login=login;
        this.password=password;
    }

    private int id;
    private String name;
    private String login;
    private String password;
    private String phone;
    private String email;
    private Integer fk_role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getFk_role() {
        return fk_role;
    }

    public void setFk_role(Integer fk_role) {
        this.fk_role = fk_role;
    }

    @Override
    public String toString() {
        String res="";
        try{
            res="Account{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", login='" + login + '\'' +
                    ", password='" + password + '\'' +
                    ", phone='" + phone + '\'' +
                    ", email='" + email + '\'' +
                    ", fk_role=" + new RoleDAO().getRole(fk_role) +
                    '}';
        }
        catch (SQLException e){res=e.toString();}
        return res;
    }
}
