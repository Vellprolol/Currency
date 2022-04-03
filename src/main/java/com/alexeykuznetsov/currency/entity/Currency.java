package com.alexeykuznetsov.currency.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Valute")
@Entity
@Table(name = "currency")
public class Currency {
    @Id
    @Column(name = "id", updatable = false, nullable = false, unique=true)
    @XmlAttribute(name = "ID")
    private String id;
    @Column(name = "name")
    @XmlElement(name = "Name")
    private String name;
    @Column(name = "value")
    @XmlElement(name = "Value")
    private String value;


    public Currency() {
    }

    public Currency(String id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
