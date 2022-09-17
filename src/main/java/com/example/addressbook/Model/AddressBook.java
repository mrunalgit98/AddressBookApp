package com.example.addressbook.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AddressBook {
    @Id
    @GeneratedValue
    public Integer id;
    public String name;
    public String city;

    public AddressBook() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public AddressBook(Integer id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }
}
