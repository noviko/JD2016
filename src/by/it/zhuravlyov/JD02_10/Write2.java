package by.it.zhuravlyov.JD02_10;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Write2 {
    private String brand;
    private Integer year;
    private String fuel;
    private String Transmission;
    private Integer mileage;

    public Write2() {};
    public String getBrand() {return brand;}
    public Integer getYear() {return year;}
    public String getFuel() {return fuel;}
    public String getTransmission() {return Transmission;}
    public Integer getMileage() {return mileage;}

    public void setBrand(String brand) {this.brand = brand;}
    public void setYear(Integer year) {this.year = year;}
    public void setFuel(String fuel) {this.fuel = fuel;}
    public void setTransmission(String transmission) {Transmission = transmission;}
    public void setMileage(Integer mileage) {this.mileage = mileage;}

    @Override
    public String toString() {
        return "Write{" +
                "\n brand='" + brand + '\'' +
                ",\n year=" + year +
                ",\n fuel='" + fuel + '\'' +
                ",\n Transmission='" + Transmission + '\'' +
                ", \n  mileage=" + mileage +
                '}';
    }

    public Write2(String brand, Integer year, String fuel, String Transmission, Integer mileage){
        this.brand = brand;
        this.year= year;
        this.fuel = fuel;
        this.mileage = mileage;
        this.Transmission = Transmission;


    }


}
