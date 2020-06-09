package com.example.projectname.api.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectname.api.dto.CustomerResponse;
import com.example.projectname.converters.SampleConverter;
import com.example.projectname.entity.Customer;
import com.example.projectname.service.SampleService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/customer")
public class ExampleController {

	@Autowired
	SampleConverter converter;
	
	@Autowired
	SampleService sampleService;
	
	@GetMapping("/{customerid}")
	@ApiOperation(value = "Get customer", httpMethod = "GET")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful request"),
        @ApiResponse(code = 500, message = "Internal server error"),
        @ApiResponse(code = 400, message = "Your request has invalid information or structure"),
        @ApiResponse(code = 422, message = "An business error happened")})
	public CustomerResponse getCustomer(@PathParam(value = "customerId") Long customerId) {
	    
	    log.info("Calling get customer...");
	    
	    Customer customer = sampleService.getCustomer(customerId);
	    
	    CustomerResponse response = converter.convert(customer);
	    
		return response;
	}
}
