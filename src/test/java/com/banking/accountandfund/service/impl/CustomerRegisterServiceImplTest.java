//package com.hcl.service.impl;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import com.hcl.dto.CustomerRegisterRequestDTO;
//import com.hcl.entity.Account;
//import com.hcl.entity.Customer;
//import com.hcl.exception.UserDefinedException;
//import com.hcl.respositry.AccountRepository;
//import com.hcl.respositry.CustomerRepository;
//import com.hcl.serviceImpl.CustomerRegisterServiceImpl;
//
//@ExtendWith(MockitoExtension.class)
//@TestMethodOrder(OrderAnnotation.class)
//public class CustomerRegisterServiceImplTest {
//
//	@Mock
//	CustomerRepository customerRepository;
//
//	@Mock
//    AccountRepository accountRepository;
//
//	@InjectMocks
//	CustomerRegisterServiceImpl customerRegisterServiceImpl;
//
//	static Customer customerDetails;
//	static Account accountDetails;
//	static CustomerRegisterRequestDTO customerRegistrationDTO;
//	@BeforeAll
//	public static void setUp() {
//
//		customerRegistrationDTO = new CustomerRegisterRequestDTO();
//		customerRegistrationDTO.setFirstName("Biragani");
//		customerRegistrationDTO.setLastName("Ramadevi");
//		customerRegistrationDTO.setEmailId("rama@gmail.com");
//		customerRegistrationDTO.setAddress("Bangalore");
//		customerRegistrationDTO.setAge(23);
//		customerRegistrationDTO.setPanNumber("ASDFE1234R");
//		customerRegistrationDTO.setGender("Female");
//		customerRegistrationDTO.setPhoneNumber("9007896542");
//
//		customerDetails = new Customer();
//		customerDetails.setCustomerId(100);
//		customerDetails.setFirstName("Biragani");
//		customerDetails.setLastName("Ramadevi");
//		customerDetails.setEmailId("rama@gmail.com");
//		customerDetails.setAddress("Bangalore");
//		customerDetails.setAge(23);
//		customerDetails.setPanNumber("ASDFE1234R");
//		customerDetails.setGender("Female");
//		customerDetails.setPhoneNumber("9007896542");
//
//		accountDetails = new Account();
//		accountDetails.setAccountId(123456789);
//		accountDetails.setAccountType("saving");
//		accountDetails.setIfsccode("HDFC00001276");
//		accountDetails.setBranchAddress("Bangalore");
//		accountDetails.setOpeningBalance(10000.00);
//		accountDetails.setCurrentBalance(10000.00);
//		accountDetails.setCustomerDetails(customerDetails);
//		System.out.println(customerDetails);
//
//	}
//
//	@Test
//	@Order(1)
//	@DisplayName("Save customerDetails:Postive Scenario")
//	public void savecustomerDetailsTest() throws UserDefinedException {
//		when(customerRepository.findByPanNumber(customerRegistrationDTO.getPanNumber())).thenReturn(null);
//
//		when(customerRepository.save(any(Customer.class))).thenAnswer(i -> {
//			customerDetails = i.getArgument(0);
//			customerDetails.setCustomerId(120);
//			return customerDetails;
//		});
//
//		when(accountRepository.save(any(Account.class))).thenAnswer(i -> {
//			accountDetails = i.getArgument(0);
//			accountDetails.setAccountId(123456789);
//			return accountDetails;
//		});
//		String result = customerRegisterServiceImpl.addCustomer(customerRegistrationDTO);
//		System.out.println(result);
//		verify(customerRepository).save(customerDetails);
//		verify(accountRepository).save(accountDetails);
//		assertEquals("Customer registered successfully and Account Number " + accountDetails.getAccountNumber()
//				+ " with opening Balance of 10000.00 is opened", result);
//
//	}
//
//	@Test
//	@Order(2)
//	@DisplayName("Save customerDetails: Negative Scenario")
//	public void savecustomerDetailsTest1() throws UserDefinedException {
//		when(customerRepository.findByPanNumber(customerRegistrationDTO.getPanNumber())).thenReturn(customerDetails);
//		assertThrows(UserDefinedException.class,
//				() -> customerRegisterServiceImpl.addCustomer(customerRegistrationDTO));
//	}
//}
