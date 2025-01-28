package com.yunusyalcinkaya.customerservice.service.impl;

import com.yunusyalcinkaya.customerservice.dto.AddressInformation;
import com.yunusyalcinkaya.customerservice.dto.CustomerInformation;
import com.yunusyalcinkaya.customerservice.entity.Customer;
import com.yunusyalcinkaya.customerservice.repository.CustomerRepository;
import com.yunusyalcinkaya.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    public CustomerInformation getByCustomerNumber(String customerNumber) {
        Customer customer = customerRepository.findByCustomerNumber(customerNumber);
        CustomerInformation customerInformation = modelMapper.map(customer, CustomerInformation.class);

        List<AddressInformation> addressInformationList = new ArrayList<>();
        customer.getAddressList().forEach(address ->
                addressInformationList.add(modelMapper.map(address, AddressInformation.class)));

        customerInformation.setAddressList(addressInformationList);

        return customerInformation;
    }
}
