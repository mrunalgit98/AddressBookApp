package com.example.addressbook.DTO;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AddressBookDto {
    public String name;
    public String zip;
    public String city;


}
