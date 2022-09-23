package com.example.addressbook.Service;

import com.example.addressbook.DTO.AddressBookDto;
import com.example.addressbook.Model.AddressBook;

public interface IAddress {
    AddressBook Add (AddressBookDto addressBookDto);

    AddressBook updateById(Integer id , AddressBookDto addressBookDTO);
}
