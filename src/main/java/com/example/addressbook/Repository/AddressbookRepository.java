package com.example.addressbook.Repository;

import com.example.addressbook.Model.AddressBook;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressbookRepository extends JpaRepository<AddressBook,Integer> {
}
