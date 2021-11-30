//package com.hcl.controller;
//
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
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
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import com.hcl.dto.CustomerRegisterRequestDTO;
//import com.hcl.exception.UserDefinedException;
//import com.hcl.service.CustomerRegisterService;
//
//@ExtendWith(MockitoExtension.class)
//@TestMethodOrder(OrderAnnotation.class)
//public class CustomerRegisterControllerTest {
//
//	@Mock
//    CustomerRegisterService customerRegisterService;
//
//	@InjectMocks
//	CustomerRegisterController customerRegisterController;
//
//	static  CustomerRegisterRequestDTO customerRegistrationDTO;
//	@BeforeAll
//	public static void setUp() {
//		customerRegistrationDTO = new CustomerRegisterRequestDTO();
//		customerRegistrationDTO.setFirstName("Biragani");
//		customerRegistrationDTO.setLastName("Ramadevi");
//		customerRegistrationDTO.setEmailId("rama@gmail.com");
//		customerRegistrationDTO.setAddress("Bangalore");
//		customerRegistrationDTO.setAge(23);
//		customerRegistrationDTO.setPanNumber("ASDFE1234R");
//		customerRegistrationDTO.setGender("Female");
//		customerRegistrationDTO.setPhoneNumber("9007896542");
//	}
//	@Test
//	@Order(1)
//	@DisplayName("Customer Registration:Positive Scenario")
//	public void customerRegistrationTest1() throws UserDefinedException {
//
//
//		when(customerRegisterService.addCustomer(customerRegistrationDTO)).thenReturn("Registered Successfully");
//
//		ResponseEntity<String> result = customerRegisterController.customerRegistration(customerRegistrationDTO);
//
//		verify(customerRegisterService).addCustomer(customerRegistrationDTO);
//		assertEquals("Registered Successfully", result.getBody());
//		assertEquals(HttpStatus.OK, result.getStatusCode());
//	}
//
//	@Test
//	@Order(2)
//	@DisplayName("Customer Registration:Negative Scenario")
//	public void customerRegistrationTest2() throws UserDefinedException {
//
//
//		when(customerRegisterService.addCustomer(customerRegistrationDTO)).thenThrow(UserDefinedException.class);
//		assertThrows(UserDefinedException.class,()->customerRegisterController.customerRegistration(customerRegistrationDTO));
//
//	}
//
//
//}
