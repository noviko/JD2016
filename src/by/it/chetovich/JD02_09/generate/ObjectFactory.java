//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.03.28 at 11:04:39 PM EET 
//


package by.it.chetovich.JD02_09.generate;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the by.it.chetovich.jd02_09.generate package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: by.it.chetovich.jd02_09.generate
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Hospital }
     * 
     */
    public Hospital createHospital() {
        return new Hospital();
    }

    /**
     * Create an instance of {@link Diagnoses }
     * 
     */
    public Diagnoses createDiagnoses() {
        return new Diagnoses();
    }

    /**
     * Create an instance of {@link Prescribings }
     * 
     */
    public Prescribings createPrescribings() {
        return new Prescribings();
    }

    /**
     * Create an instance of {@link Drugs }
     * 
     */
    public Drugs createDrugs() {
        return new Drugs();
    }

    /**
     * Create an instance of {@link Prescribing }
     * 
     */
    public Prescribing createPrescribing() {
        return new Prescribing();
    }

    /**
     * Create an instance of {@link Diagnosis }
     * 
     */
    public Diagnosis createDiagnosis() {
        return new Diagnosis();
    }

}
