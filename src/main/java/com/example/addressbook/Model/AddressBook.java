package com.example.addressbook.Model;

import com.example.addressbook.DTO.AddressBookDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.intellij.lang.annotations.Pattern;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "personId")
    public Integer id;

    public String name;
//    @ElementCollection
//    @CollectionTable(name = "city",joinColumns = @JoinTable(schema = "address_book"))
    public String city;
    public Integer zip;

   public Long phone;
   public String email;



    public AddressBook(AddressBookDto addressBookDto) {

        this.name=addressBookDto.name;
        this.city=addressBookDto.city;
        this.zip=addressBookDto.zip;
        this.phone=addressBookDto.phone;
        this.email=addressBookDto.email;
    }
}
