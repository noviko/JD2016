package by.it.chetovich.JD02_09.manual;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Prescribing
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)     // FIELD - все поля в XML
@XmlType(name = "Prescribing", propOrder = {  // PROPERTY - только  с геттерами и сеттерами
        "type",                           // PUBLIC_MEMBER - только public
        "price"                       // NONE - ни одно

})

public class Prescribing {

    @XmlAttribute(required = true) //опишем логин как аттрибут
    //@XmlJavaTypeAdapter(CollapsedStringAdapter.class) //тип адаптера
    //@XmlID                         //и ключевой (уникальный)
    private String id;
    @XmlElement(required = true)
    private String type;
    @XmlElement(required = true)
    private String price;
    @XmlAttribute(required = false)
    private String executor;

    public Prescribing() { } // необходим для маршаллизации/демаршалиизации XML

    public Prescribing(String id, String type, String price, String executor) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.executor = executor;
    }

    //getters

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getPrice() {
        return price;
    }

    public String getExecutor() {
        return executor;
    }

    //setters

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    //как выводить в строку
    public String toString() {
        return "\nID: " + id + "\ntype: " + type + "\nprice: " + price
                + "\nexecutor: " + executor;
    }



}
