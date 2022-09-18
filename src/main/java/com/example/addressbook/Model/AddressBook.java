package com.example.addressbook.Model;

import com.example.addressbook.DTO.AddressBookDto;

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
  public String zip;
    public AddressBook(AddressBookDto addressBookDto) {
this.name=addressBookDto.getName();
this.city=addressBookDto.getCity();
this.zip=addressBookDto.getZip();
    }

    public AddressBook(AddressBook addressBook,Integer id) {
        this.id = id;
        this.name = addressBook.name;
        this.city = addressBook.city;
        this.zip= addressBook.zip;
    }

    public AddressBook() {

    }

    public AddressBook(AddressBookDto addressBookDTO, Integer id) {

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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public AddressBook(Integer id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
