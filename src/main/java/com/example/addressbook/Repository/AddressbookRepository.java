package com.example.addressbook.Repository;

import com.example.addressbook.Model.AddressBook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressbookRepository extends JpaRepository<AddressBook,Integer> {
    List<AddressBook> findContactByCity(String city);

   @Query(value = "SELECT * FROM addressbookdto.address_book order by city;",nativeQuery = true)
   List<AddressBook> orderContactsByCity();

   @Query(value = "SELECT * FROM addressbookdto.address_book order by state",nativeQuery = true)
   List<AddressBook>orderContactsByState();
}
