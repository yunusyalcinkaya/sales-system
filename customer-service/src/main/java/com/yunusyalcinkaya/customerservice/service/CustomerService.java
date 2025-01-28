package com.yunusyalcinkaya.customerservice.service;

import com.yunusyalcinkaya.customerservice.dto.CustomerInformation;

public interface CustomerService {

    CustomerInformation getByCustomerNumber(String customerNumber);
}
