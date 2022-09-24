package com.example.addressbook.Service;

import com.example.addressbook.DTO.AddressBookDto;
import com.example.addressbook.Model.AddressBook;

import java.util.List;
import java.util.Optional;

public interface IAddress {
    AddressBook Add (AddressBookDto addressBookDto);

    //Created service to get all user
    List<AddressBook>getListOfAddresses();

    AddressBook updateById(Integer id , AddressBookDto addressBookDTO);
    Optional<AddressBook> getIdOfAddresses(int id);
     void deleteContact(Integer id);

    List<AddressBook> getContactsByCity(String city);

    List<AddressBook> orderContactsByCity();
}
