package by.it.telushko.jd03_03;

import java.sql.SQLException;

/**
 * Created by Владимир on 10.04.2016.
 */
public class Vehicle {
    public Vehicle(){}
    public Vehicle(String brand,String model,int year,Integer owner){
        this.brand=brand;
        this.model=model;
        this.year=year;
        this.fk_owner=owner;
    }

    private Integer fk_owner,year,id;
    private String brand,model;

    public Integer getFk_owner() {
        return fk_owner;
    }

    public void setFk_owner(Integer fk_owner) {
        this.fk_owner = fk_owner;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        String res="";
        try{
            res="Vehicle{" +
                    "fk_owner=" + fk_owner +
                    ", year=" + year +
                    ", id=" + id +
                    ", brand='" + brand + '\'' +
                    ", model='" + model + '\'' +
                    '}';
        }
        catch (Exception e){res=e.toString();}
        return res;
    }

}
