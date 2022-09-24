package com.example.addressbook.DTO;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data

public class AddressBookDto {

   @Pattern(regexp = "[A-Z]{1}[a-zA-Z]{2,}",message = "Name is Invalid")
    public String name;
    @NotNull(message = "zip cannot be empty")
    public Integer zip;
    @NotEmpty(message = "city cannot be empty")
     public String city;
//    @Pattern(regexp ="(91-)?[0-9]{10}",message="Phone number is not valid")
     public Long phone;
     public String email;

}
