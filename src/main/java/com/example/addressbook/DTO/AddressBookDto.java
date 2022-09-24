package com.example.addressbook.DTO;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data

public class AddressBookDto {

   @Pattern(regexp = "[A-Z]{1}[a-zA-Z]{2,}",message = "Name is Invalid")
    public String name;
    public Integer zip;
     public String city;
     public Long phone;

}
