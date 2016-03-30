package by.it.novik.JD02_10;


import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
class Person {

    private String name;
    private String surname;
    private int age;
    private String education;
    private String address;


    public Person() {
    }

    public Person(String name, String surname, int age, String education, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.education = education;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getEducation() {
        return education;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "\nname='" + name + '\'' +
                ", \nsurname='" + surname + '\'' +
                ", \nage=" + age +
                ", \neducation='" + education + '\'' +
                ", \naddress='" + address + '\'' +
                "\n"+'}';
    }
}

