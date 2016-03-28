package by.it.chetovich.JD02_09.manual;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by user_2 on 28.03.2016.
 */
public class Diagnosis {

    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)     // FIELD - все поля в XML
    @XmlType(name = "Student", propOrder = {  // PROPERTY - только  с геттерами и сеттерами
            "name",                           // PUBLIC_MEMBER - только public
            "nickname",                       // NONE - ни одно
            "telephone",
            "address"
    })
    public class Student {
        @XmlAttribute(required = true) //опишем логин как аттрибут
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class) //тип адаптера
        @XmlID                         //и ключевой (уникальный)
        private String login;
        @XmlElement(required = true)
        private String name;
        @XmlElement(required = true)
        private String nickname;
        @XmlAttribute(required = false)
        private String faculty;
        @XmlElement(required = true)
        private int telephone;
        @XmlElement(required = true)
        private Address address = new Address();
        public Student() { } // необходим для маршаллизации/демаршалиизации XML

        public Student(String login, String name, String nickname, String faculty, int telephone, Address address) {
            this.login = login;
            this.name = name;
            this.nickname = nickname;
            this.faculty = faculty;
            this.telephone = telephone;
            this.address = address;
        }
}
