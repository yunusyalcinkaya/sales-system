package com.yunusyalcinkaya.customerservice.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class CustomerInformation {

    private String customerNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private List<AddressInformation> addressList;
}
