//package com.hcl.controller;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
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
//import com.hcl.dto.FundTransferRequestDTO;
//import com.hcl.dto.MonthlyStatementResponseDTO;
//import com.hcl.exception.UserDefinedException;
//import com.hcl.service.TransactionService;
//
//@ExtendWith(MockitoExtension.class)
//@TestMethodOrder(OrderAnnotation.class)
//public class TransactionControllerTest {
//
//	@Mock
//    TransactionService transactionService;
//
//	@InjectMocks
//	TransactionController transactionController;
//
//	static FundTransferRequestDTO fundTransferRequestDTO;
//	static MonthlyStatementResponseDTO monthlyList;
//	static List<MonthlyStatementResponseDTO> monthList;
//
//	@BeforeAll
//	public static void setUp() {
//		fundTransferRequestDTO = new FundTransferRequestDTO();
//
//		fundTransferRequestDTO.setToAccount(123456789);
//		fundTransferRequestDTO.setFromAccount(987654321);
//		fundTransferRequestDTO.setAmount(300.00);
//		fundTransferRequestDTO.setRemarks("Travel Allowances");
//
//	monthlyList=new MonthlyStatementResponseDTO();
//	monthlyList.setTransactionId(900);
//	monthlyList.setAccountNo(123456789);
//	monthlyList.setAmount(1200.0);
//	monthlyList.setCredit_debit("debit");
//	monthlyList.setCurrentBal(9000.0);
//	monthlyList.setMessage("Recieved");
//	monthlyList.setTransactionDate(new Date());
//
//	monthList=new ArrayList<MonthlyStatementResponseDTO>();
//	monthList.add(monthlyList);
//
//
//
//	}
//
//	@Test
//	@Order(1)
//	@DisplayName("Fund Transfer :Positive Scenario")
//	public void fundTransferTest1() throws UserDefinedException {
//
//		when(transactionService.fundTransfer(fundTransferRequestDTO)).thenReturn("Fund Transferred  Successfully");
//
//		ResponseEntity<String> result = transactionController.fundTransfer(fundTransferRequestDTO);
//
//		verify(transactionService).fundTransfer(fundTransferRequestDTO);
//		assertEquals("Fund Transferred  Successfully", result.getBody());
//		assertEquals(HttpStatus.OK, result.getStatusCode());
//	}
//
//
//	@Test
//	@Order(2)
//	@DisplayName("Monthly Statement :Positive Scenario")
//	public void getMonthStatementTest1() throws UserDefinedException {
//
//		when(transactionService.getMonthlyStatement(123456789, 8, 2021)).thenReturn(monthList);
//		List<MonthlyStatementResponseDTO> result=transactionController.getMonthStatement(123456789, 8, 2021);
//		verify(transactionService).getMonthlyStatement(123456789, 8, 2021);
//		assertEquals(monthList,result);
//
//	}
//
//	@Test
//	@Order(3)
//	@DisplayName("Fund Transfer :Negative Scenario")
//	public void fundTransferTest2() throws UserDefinedException {
//
//		when(transactionService.fundTransfer(fundTransferRequestDTO)).thenThrow(UserDefinedException.class);
//		assertThrows(UserDefinedException.class, () -> transactionController.fundTransfer(fundTransferRequestDTO));
//
//	}
//
//	@Test
//	@Order(4)
//	@DisplayName("Monthly Statement :Negative Scenario")
//	public void getMonthStatementTest2() throws UserDefinedException {
//
//		when(transactionService.getMonthlyStatement(123456789, 8, 2021)).thenThrow(UserDefinedException.class);
//		assertThrows(UserDefinedException.class, () -> transactionController.getMonthStatement(123456789, 8,2021));
//
//	}
//}
