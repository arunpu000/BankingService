package com.banking.accountandfund.controller;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.banking.accountandfund.dto.CustomerRegisterRequestDTO;
import com.banking.accountandfund.exception.UserDefinedException;
import com.banking.accountandfund.service.CustomerRegisterService;

@RestController
@Validated
@RequestMapping("/customerregistration")
public class CustomerRegisterController {

	@Autowired
	Environment environment;

	@Autowired
	private CustomerRegisterService customerRegisterService;

	@PostMapping
	public ResponseEntity<String> customerRegistration(
			@Valid @RequestBody CustomerRegisterRequestDTO customerRegistrationDTO) throws UserDefinedException {
		String response = customerRegisterService.registerCustomer(customerRegistrationDTO);
		 return new ResponseEntity<String>(response,HttpStatus.OK);

	}

	@GetMapping("/checkCustomerExist/{phoneNumber}")
	public ResponseEntity<Boolean> customerExist(@PathVariable @NotNull Long phoneNumber){
		Boolean response = customerRegisterService.checkExistingCustomer(phoneNumber);
		return new ResponseEntity<Boolean>(response,HttpStatus.OK);
	}

	@GetMapping("/checkServiceStatus")
	public String getServiceStatus(){
		return environment.getProperty("local.server.port");
	}

}
