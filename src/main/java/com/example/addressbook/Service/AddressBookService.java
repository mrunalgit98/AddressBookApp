package com.example.addressbook.Service;


import com.example.addressbook.DTO.AddressBookDto;
import com.example.addressbook.Model.AddressBook;
import com.example.addressbook.Repository.AddressbookRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService implements IAddress {

    //Autowired repository class to inject its dependency
    @Autowired
    AddressbookRepository repository;



    @Override
    public String Add(AddressBookDto addressBookDto) {
        AddressBook addressBook=new AddressBook(addressBookDto);
        repository.save(addressBook);
        return addressBook.toString();
    }
    //Created service method which serves controller api to retrieve all records
    public Optional<AddressBook> getIdOfAddresses(int id) {
        Optional<AddressBook> addressBook = repository.findById(id);
        return addressBook;
    }
//Created service to get all user
    public List<AddressBook>getListOfAddresses(){
        List<AddressBook>addressBook=repository.findAll();
        return addressBook;
    }

    //Created service method which serves controller api to update record by id
    public AddressBook updateById(Integer id, AddressBookDto addressBookDTO) {
        Optional<AddressBook>addressBook=repository.findById(id);
        if(addressBook.isPresent()){
            addressBook.get().setName(addressBookDTO.getName());
            addressBook.get().setCity(addressBookDTO.getCity());
            addressBook.get().setZip(addressBookDTO.getZip());
            repository.save(addressBook.get());
            return addressBook.get();
        }else {
            return null;
        }
    }

    //Created service method which serves controller api to delete record by id
    public void deleteContact(Integer id) {
        repository.deleteById(id);
    }
}