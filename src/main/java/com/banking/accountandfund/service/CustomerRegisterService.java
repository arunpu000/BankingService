package com.banking.accountandfund.service;


import com.banking.accountandfund.exception.UserDefinedException;
import com.banking.accountandfund.dto.CustomerRegisterRequestDTO;

public interface CustomerRegisterService {

	String registerCustomer( CustomerRegisterRequestDTO customerRegistrationDTO) throws UserDefinedException;
	boolean checkExistingCustomer(Long phoneNumber);


}
