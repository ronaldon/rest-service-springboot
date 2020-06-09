package com.example.projectname.converters;

import org.springframework.stereotype.Component;

import com.example.projectname.api.dto.CustomerResponse;
import com.example.projectname.entity.Customer;

@Component
public class SampleConverter {

    public CustomerResponse convert(final Customer customer) {

        return CustomerResponse.builder()
           .firstname(customer.getName())
           .lastname(customer.getLastName())
           .email(customer.getEmail())
           .cellphone(customer.getCellPhone())
           .build();
        
    }

}
