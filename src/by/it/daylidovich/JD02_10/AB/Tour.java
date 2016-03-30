package by.it.daylidovich.JD02_10.AB;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tour", propOrder = {
    "country",
    "cost",
    "transport",
    "hotelType",
    "foodComplex"
})
public class Tour {

    @XmlElement(required = true)
    protected String country;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected Integer cost;
    @XmlElement(required = true)
    protected String transport;
    @XmlElement(name = "hotel_type", required = true)
    protected String hotelType;
    @XmlElement(name = "food_complex", required = true)
    protected String foodComplex;
    @XmlAttribute(name = "type")
    protected String type;

    public Tour(){}

    public Tour(String type, String country, int cost, String transport, String hotelType, String foodComplex){
        setType(type);
        setCountry(country);
        setCost(cost);
        setTransport(transport);
        setHotelType(hotelType);
        setFoodComplex(foodComplex);
    }


    public String getCountry() {
        return country;
    }


    public void setCountry(String value) {
        this.country = value;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer value) {
        this.cost = value;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String value) {
        this.transport = value;
    }

    public String getHotelType() {
        return hotelType;
    }

    public void setHotelType(String value) {
        this.hotelType = value;
    }

    public String getFoodComplex() {
        return foodComplex;
    }

    public void setFoodComplex(String value) {
        this.foodComplex = value;
    }

    public String getType() {
        if (type == null) {
            return "relaxing";
        } else {
            return type;
        }
    }

    public void setType(String value) {
        this.type = value;
    }

    @Override
    public String toString() {
        return "Tour{" +
                ", type='" + type + '\'' +
                "country='" + country + '\'' +
                ", cost=" + cost +
                ", transport='" + transport + '\'' +
                ", hotelType='" + hotelType + '\'' +
                ", foodComplex='" + foodComplex + '\'' + '}';
    }
}
