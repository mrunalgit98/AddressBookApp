package com.example.addressbook.Model;

import com.example.addressbook.DTO.AddressBookDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public Integer personId;

    public String name;

    public String city;
    public Integer zip;

    public String phone;
    public String email;
    public String state;
    public String country;

    public  AddressBook (AddressBookDto addressBookDto) {
        this.name=addressBookDto.getName();
        this.city=addressBookDto.getCity();
        this.zip=addressBookDto.getZip();
        this.phone=addressBookDto.getPhone();
        this.email=addressBookDto.getEmail();
        this.state=addressBookDto.getState();
        this.country=addressBookDto.getCountry();

    }

//    public AddressBook( Integer id) {
//    }


//    public  void AddressBook() {
//        this.AddressBook();
//    }



}

//Save, GetAll, GetById, DeleteById, Update, sortByprice high and low, Solrt by bookName, update bookQuantity,