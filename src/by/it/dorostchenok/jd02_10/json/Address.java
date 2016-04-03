package by.it.dorostchenok.jd02_10.json;

public class Address {
    private String city;
    private String street;
    private String country;
    private int zip;
    private int building;

    public Address(String country, String city, String street, int building, int zip){
        this.country = country;
        this.city = city;
        this.street = street;
        this.building = building;
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", country='" + country + '\'' +
                ", zip=" + zip +
                ", building=" + building +
                '}';
    }
}
