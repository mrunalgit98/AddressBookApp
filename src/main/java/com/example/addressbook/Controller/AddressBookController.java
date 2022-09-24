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

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
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
    public ResponseEntity<ResponseDto> postData(@Valid @RequestBody AddressBookDto addressBook) {
         service.Add(addressBook);
        ResponseDto response = new ResponseDto("New Contact Added in Addressbook : ", addressBook);
        return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<AddressBookDto> getAddressById(@PathVariable Integer id) {
       Optional<AddressBook> addressBook=   service.getIdOfAddresses(id);
        ResponseDto response = new ResponseDto("Addressbook of given id: ", addressBook);
        return new ResponseEntity(response, HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDto> updateById(@PathVariable Integer id, @RequestBody@Valid AddressBookDto addressBookDTO) {
        AddressBook newContact = service.updateById(id, addressBookDTO);
        ResponseDto response = new ResponseDto("Address-book updated : ", newContact);
        return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDataById(@PathVariable Integer id) {
        service.deleteContact(id);
        return new ResponseEntity<String>("Contact deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<ResponseDto> getContactsByCity(@PathVariable("city") String city){
        List<AddressBook> addressBookList ;
        addressBookList = service.getContactsByCity(city);
        ResponseDto responseDTO = new ResponseDto("Get Call For ID Department Successful",addressBookList);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
    @GetMapping(value = {"/city1"})
    public ResponseEntity<ResponseDto> orderContactsByCity() {
        List<AddressBook> addressBookList = service.orderContactsByCity();
        ResponseDto responseDTO = new ResponseDto("Contact details sorted by City", addressBookList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}