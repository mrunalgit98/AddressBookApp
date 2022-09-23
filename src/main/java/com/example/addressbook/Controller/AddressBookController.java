package com.example.addressbook.Controller;


import com.example.addressbook.DTO.AddressBookDto;
import com.example.addressbook.DTO.ResponseDto;
import com.example.addressbook.Model.AddressBook;
import com.example.addressbook.Repository.AddressbookRepository;
import com.example.addressbook.Service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AddressBookController {

    @Autowired
    AddressBookService service;

    @GetMapping("/hello")
    public String getMessage() {
        return "Welcome to addressBookService App";
    }
    @GetMapping("/get")
    public ResponseEntity<ResponseDto> getAllData() {
        List<AddressBook> addressBook = service.getListOfAddresses();
        ResponseDto response = new ResponseDto("Addresbook :", addressBook);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<ResponseDto> postData(@RequestBody AddressBookDto addressBook) {
         service.Add(addressBook);
        ResponseDto response = new ResponseDto("New Contact Added in Addressbook : ", addressBook);
        return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<AddressBookDto> getAddressById(@PathVariable int id) {
       Optional<AddressBook> addressBook= service.getIdOfAddresses(id);
        ResponseDto response = new ResponseDto("Addressbook of given id: ", addressBook);
        return new ResponseEntity(response, HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDto> updateById(@PathVariable Integer id, @RequestBody AddressBookDto addressBookDTO) {
        AddressBook newContact = service.updateById(id, addressBookDTO);
        ResponseDto response = new ResponseDto("Address-book updated : ", newContact);
        return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDataById(@PathVariable Integer id) {
        service.deleteContact(id);
        return new ResponseEntity<String>("Contact deleted successfully", HttpStatus.OK);
    }
}