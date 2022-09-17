package com.example.addressbook.Controller;


import com.example.addressbook.Model.AddressBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AddressBookController {



    @GetMapping("/hello")
    public String getMessage() {
        return "Welcome to addressBookService App";
    }

}