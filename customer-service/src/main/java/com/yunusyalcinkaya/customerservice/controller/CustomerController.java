package com.yunusyalcinkaya.customerservice.controller;

import com.yunusyalcinkaya.commonutils.dto.CustomResponseEntity;
import com.yunusyalcinkaya.customerservice.dto.CustomerInformation;
import com.yunusyalcinkaya.customerservice.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Operation(
            summary = "Get customer by customer number",
            description = "Retrieve customer details by providing the customer name.",
            parameters = {
                    @Parameter(
                            name = "customerNumber",
                            description = "The unique number of the customer",
                            required = true,
                            example = "1111111111"
                    )
            }
    )
    @GetMapping("/{customerNumber}")
    public CustomResponseEntity<CustomerInformation> getByCustomerNumber(@PathVariable String customerNumber) {
        return new CustomResponseEntity<>(customerService.getByCustomerNumber(customerNumber));
    }
}
