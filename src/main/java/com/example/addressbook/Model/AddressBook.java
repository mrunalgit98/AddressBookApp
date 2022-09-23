package com.example.addressbook.Model;

import com.example.addressbook.DTO.AddressBookDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddressBook {
    @Id
    @GeneratedValue
    public Integer id;
    public String name;
    public String city;
  public String zip;


    public AddressBook(AddressBookDto addressBookDto) {
        this.name=addressBookDto.name;
        this.city=addressBookDto.city;
        this.zip=addressBookDto.zip;
    }
}
