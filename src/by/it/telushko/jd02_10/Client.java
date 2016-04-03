package by.it.telushko.jd02_10;

import java.util.ArrayList;
import java.util.List;


public class Client {
    private String name;
    private int id;
    private List contacts = new ArrayList<>();
    public Client(){};
    public Client (String name,String[] arrayContacts){
        this.id=++id;
        this.name=name;
        contacts.add(arrayContacts);
    }
    public int getId(){return id;}
    public void setId(int id){this.id=id;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public List getContacts(){return contacts;}
    @Override
    public String toString(){
    return "client "+"id = "+id+"\nname = "+name+"\ncontacts ="+contacts;
    }

}
