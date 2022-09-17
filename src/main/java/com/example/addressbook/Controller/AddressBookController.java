package com.example.addressbook.Controller;


import com.example.addressbook.Model.AddressBook;
import com.example.addressbook.Repository.AddressbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AddressBookController {

    @Autowired
    AddressbookRepository repository;

    @GetMapping("/hello")
    public String getMessage() {
        return "Welcome to addressBookService App";
    }
    @PostMapping("/post")
    public AddressBook postAddress(@RequestBody AddressBook addressBook) {
//        AddressBook newAddressBook = new AddressBook(addressBook);
//        repository.save(newAddressBook);
        return addressBook;
    }


    @GetMapping("/get")
    public List<AddressBook> getAddress() {
        List<AddressBook> addressBook = repository.findAll();
        return addressBook;
    }


    @GetMapping("/get/{id}")
    public AddressBook getAddressById(@PathVariable Integer id) {
        Optional<AddressBook> addressBook = repository.findById(id);
        return addressBook.get();
    }
//
//    @PutMapping("/updateData/{id}")
//    public AddressBook updateById(@PathVariable Integer id, @RequestBody AddressBook addressBook) {
//        AddressBook newAddressBook = new AddressBook(addressBook, id);
//        repository.save(newAddressBook);
//        return newAddressBook;
//    }
//
//
//    @DeleteMapping("/delete/{id}")
//    public String deleteAddress(@PathVariable Integer id) {
//        repository.deleteById(id);
//        return "Address of id: " + id + " has been deleted";
//    }

}