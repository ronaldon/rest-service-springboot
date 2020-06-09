package com.example.projectname.service.impl;

import org.springframework.stereotype.Service;

import com.example.projectname.entity.Customer;
import com.example.projectname.service.SampleService;

@Service
public class SampleServiceImpl implements SampleService {

    @Override
    public Customer getCustomer(Long id) {
        // TODO Auto-generated method stub
        return new Customer();
    }

}
