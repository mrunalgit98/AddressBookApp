package com.example.addressbook.Service;


import com.example.addressbook.DTO.AddressBookDto;
import com.example.addressbook.Exception.AddressExceptionMessage;
import com.example.addressbook.Model.AddressBook;
import com.example.addressbook.Repository.AddressbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookService implements IAddress {

    //Autowired repository class to inject its dependency
    @Autowired
    AddressbookRepository repository;



    @Override
    public AddressBook Add(AddressBookDto addressBookDto) {
        List<AddressBook> addressBook=repository.findAll();
     for (AddressBook addressBook1 :addressBook){
         if (addressBook1.getName().equals(addressBookDto.getName())){
         throw (new AddressExceptionMessage("Name already exist please enter different name"));
     }
    }
     AddressBook addressBook2=new AddressBook(addressBookDto);
     repository.save(addressBook2);
     return addressBook2;
    }
    //Created service method whi
    // ch serves controller api to retrieve all records
    @Override
    public AddressBook getIdOfAddresses(int id) {

        return repository.findById(id)
                .orElseThrow(() -> new AddressExceptionMessage("Person not found"));
    }
    //Created service to get all user
    @Override
    public List<AddressBook>getListOfAddresses(){
        List<AddressBook>addressBook=repository.findAll();
        return addressBook;
    }

    @Override
    public Object updateAddressBookData(int id, AddressBookDto addressBookDTO) {
       if(repository.findById(id).isPresent()){
           List<AddressBook> addressBooks =repository.findAll();
            for (AddressBook u :addressBooks){
                if(u.getName().equals(addressBookDTO.getName())){
                    return "name already present";
                }
            }
        }else throw (new AddressExceptionMessage("id " + id + " not found"));

          AddressBook addressBookData=new AddressBook(addressBookDTO);
          addressBookData.setPersonId(id);
        repository.save(addressBookData);
        return addressBookData;
        }
    //Created service method which serves controller api to delete record by id
    public String deleteContact(Integer id) {
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
            return "id" + id + " has been deleted";
        }else throw (new AddressExceptionMessage("id " + id + " not found"));
    }
    @Override
    public List<AddressBook> getContactsByCity(String city) {
        List<AddressBook>addressBooks=repository.findContactByCity(city);
        if (addressBooks.isEmpty()){

            throw new AddressExceptionMessage("City not Found");
        }
        return addressBooks;
    }

    //Created service method which serves controller api to order record by city


    @Override
    public List<AddressBook> orderContactsByCity() {
        List<AddressBook>addressbook=repository.orderContactsByCity();
        return addressbook;

    }
    @Override
    public List<AddressBook>orderContactByState(){
        List<AddressBook>addressBooks=repository.orderContactsByState();
        return addressBooks;
    }
}