package com.example.addressbook.Repository;

import com.example.addressbook.Model.AddressBook;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressbookRepository extends JpaRepository<AddressBook,Integer> {
    List<AddressBook> findContactByCity(String city);
}
