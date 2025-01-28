package com.yunusyalcinkaya.customerservice.dto;

import lombok.Data;

@Data
public class AddressInformation {

    private String city;
    private String district;
    private String street;
    private short buildingNumber;
    private short doorNumber;
    private int postalCode;
}
