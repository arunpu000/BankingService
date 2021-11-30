package com.banking.accountandfund.serviceImpl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

import com.banking.accountandfund.dto.CustomerRegisterRequestDTO;
import com.banking.accountandfund.entity.Account;
import com.banking.accountandfund.entity.Customer;
import com.banking.accountandfund.exception.UserDefinedException;
import com.banking.accountandfund.respositry.AccountRepository;
import com.banking.accountandfund.respositry.CustomerRepository;
import com.banking.accountandfund.service.CustomerRegisterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerRegisterServiceImpl implements CustomerRegisterService {

	@Autowired
	public CustomerRepository customerRepository;

	@Autowired
	public AccountRepository accountRepository;

	@Override
	public String registerCustomer(CustomerRegisterRequestDTO customerRegistrationDTO)
			throws UserDefinedException {

		Customer customerDetails = new Customer();

		// Generating random digit number for account
		Random r=new Random();

		if (customerRepository.findByPanNumber(
				customerRegistrationDTO.getPanNumber())==null) {

		BeanUtils.copyProperties(customerRegistrationDTO, customerDetails);

		//Saving Customer Details in Customer Table
		customerRepository.save(customerDetails);

		// Creating account for Customer
		Account accountDetails = new Account();
		accountDetails.setAccountNumber(r.nextInt(999999999));
		accountDetails.setOpeningBalance(customerRegistrationDTO.getInitialamount());
		accountDetails.setCurrentBalance(customerRegistrationDTO.getInitialamount());
		accountDetails.setCustomerDetails(customerDetails);
		accountDetails.setCreationDate(LocalDateTime.now());

		// Saving account details in account table
		accountRepository.save(accountDetails);

		return "User registered successfully and Account Number "+
				accountDetails.getAccountNumber()+" with opening Balance of "+
				accountDetails.getOpeningBalance()+" is opened";
	}

	else {
			return "User was already registered";
		}

}

	@Override
	public boolean checkExistingCustomer(Long phoneNumber) throws UserDefinedException {
		boolean result=false;
		if (customerRepository.findByPhoneNumber(
				phoneNumber)==null)
		{
			result = false;
		}
		else{
			result = true;
		}
		return result;
	}
}