//package com.hcl.service.impl;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.BeanUtils;
//
//import com.hcl.dto.FundTransferRequestDTO;
//import com.hcl.dto.MonthlyStatementResponseDTO;
//import com.hcl.entity.Account;
//import com.hcl.entity.Customer;
//import com.hcl.entity.Transaction;
//import com.hcl.exception.UserDefinedException;
//import com.hcl.respositry.AccountRepository;
//import com.hcl.respositry.TransactionRepository;
//import com.hcl.serviceImpl.TransactionServiceImpl;
//
//@ExtendWith(MockitoExtension.class)
//@TestMethodOrder(OrderAnnotation.class)
//public class TransactionServiceImplTest {
//	@Mock
//	AccountRepository accountRepository;
//
//	@Mock
//	TransactionRepository transactionRepository;
//
//	@InjectMocks
//	TransactionServiceImpl transactionServiceImpl;
//
//	static FundTransferRequestDTO fundTransferRequestDTO;
//	static MonthlyStatementResponseDTO monthlyList;
//	static List<MonthlyStatementResponseDTO> monthList;
//	static List<Transaction> transactionList;
//	static Transaction sourceAccount;
//	static Transaction destinationAccount;
//	static Account toAccountDetails;
//	static Account fromAccountDetails;
//	static Customer customerDetails;
//	static Customer customerDetails1;
//	static long checkYear;
//
////	@BeforeAll
////	public static void setUp() {
////		fundTransferRequestDTO = new FundTransferRequestDTO();
////
////		fundTransferRequestDTO.setToAccount(123456789);
////		fundTransferRequestDTO.setFromAccount(789789789);
////		fundTransferRequestDTO.setAmount(300.00);
////		fundTransferRequestDTO.setRemarks("Travel Allowances");
////
////		monthList = new ArrayList<MonthlyStatementResponseDTO>();
////
////		customerDetails = new Customer();
////		customerDetails.setCustomerId(100);
////		customerDetails.setFirstName("Biragani");
////		customerDetails.setLastName("Ramadevi");
////		customerDetails.setEmailId("rama@gmail.com");
////		customerDetails.setAddress("Bangalore");
////		customerDetails.setAge(23);
////		customerDetails.setPanNumber("ASDFE1234R");
////		customerDetails.setGender("Female");
////		customerDetails.setPhoneNumber("9007896542");
////
////		customerDetails1 = new Customer();
////		customerDetails1.setCustomerId(120);
////		customerDetails1.setFirstName("Biragani");
////		customerDetails1.setLastName("Tejaswini");
////		customerDetails1.setEmailId("teja@gmail.com");
////		customerDetails1.setAddress("Bangalore");
////		customerDetails1.setAge(23);
////		customerDetails1.setPanNumber("ERTYH6789U");
////		customerDetails1.setGender("Female");
////		customerDetails1.setPhoneNumber("9090909090");
////
////		toAccountDetails = new Account();
////		toAccountDetails.setAccountId(600);
////		toAccountDetails.setAccountNumber(123456789);
////		toAccountDetails.setAccountType("saving");
////		toAccountDetails.setBranchAddress("Hyderabad");
////		toAccountDetails.setCurrentBalance(10000.0);
////		toAccountDetails.setIfsccode("HDFC00001209");
////		toAccountDetails.setOpeningBalance(10000.0);
////		toAccountDetails.setCustomerDetails(customerDetails);
////
////		fromAccountDetails = new Account();
////		fromAccountDetails.setAccountId(610);
////		fromAccountDetails.setAccountNumber(789789789);
////		fromAccountDetails.setAccountType("saving");
////		fromAccountDetails.setBranchAddress("Hyderabad");
////		fromAccountDetails.setCurrentBalance(10000.0);
////		fromAccountDetails.setIfsccode("HDFC00001209");
////		fromAccountDetails.setOpeningBalance(10000.0);
////		fromAccountDetails.setCustomerDetails(customerDetails1);
////
////		sourceAccount = new Transaction();
////		sourceAccount.setTransactionId(200);
////		java.util.Date date = new java.util.Date();
////
////		checkYear = date.getYear() + 1900;
////
////		long time = date.getTime();
////		Timestamp transactiondate = new Timestamp(time);
////		sourceAccount.setTransactionDate(transactiondate);
////		// sourceAccount.setTransactionDate(new Date());
////		sourceAccount.setMessage("travel expensenses");
////		sourceAccount.setCurrentBal(10000.00);
////		sourceAccount.setCredit_debit("debit");
////		sourceAccount.setAmount(300.00);
////		sourceAccount.setAccountNo(789789789);
////		sourceAccount.setAccount(fromAccountDetails);
////
////		destinationAccount = new Transaction();
////		destinationAccount.setTransactionId(270);
////		destinationAccount.setTransactionDate(transactiondate);
////		destinationAccount.setMessage("travel expensenses");
////		destinationAccount.setCurrentBal(10000.00);
////		destinationAccount.setCredit_debit("credit");
////		destinationAccount.setAmount(300.00);
////		destinationAccount.setAccountNo(123456789);
////		destinationAccount.setAccount(toAccountDetails);
////
////		transactionList = new ArrayList<Transaction>();
////		transactionList.add(sourceAccount);
////
////	}
//
//	@Test
//	@Order(2)
//	@DisplayName("Fund Transfer: Positive Scenario")
//	public void fundTransferTest1() throws UserDefinedException {
//		when(accountRepository.findByAccountNumber(fromAccountDetails.getAccountNumber()))
//				.thenReturn(Optional.of(fromAccountDetails));
//
//		when(accountRepository.findByAccountNumber(toAccountDetails.getAccountNumber()))
//				.thenReturn(Optional.of(toAccountDetails));
//
//		when(accountRepository.save(fromAccountDetails)).thenReturn(fromAccountDetails);
//		when(accountRepository.save(toAccountDetails)).thenReturn(toAccountDetails);
//
////		when(transactionRepository.save(any(Transaction.class))).thenAnswer(i -> {
////			sourceAccount = i.getArgument(0);
////			sourceAccount.setTransactionId(300);
////
////			return sourceAccount;
////		});
//
//		when(transactionRepository.save(any(Transaction.class))).thenAnswer(i -> {
//			destinationAccount = i.getArgument(0);
//			destinationAccount.setTransactionId(800);
//
//			return destinationAccount;
//		});
//
//		String result = transactionServiceImpl.fundTransfer(fundTransferRequestDTO);
//		verify(accountRepository).save(fromAccountDetails);
//		verify(accountRepository).save(toAccountDetails);
//// 		verify(transactionRepository).save(sourceAccount);
//		verify(transactionRepository).save(destinationAccount);
//		assertEquals("Transaction  is done Succesfully.", result);
//	}
//
//	@Test
//	@DisplayName("Monthly statment:Positive Scenario")
//	public void MonthlyStatmentTest1() throws UserDefinedException {
//		when(accountRepository.findByAccountNumber(123456789)).thenReturn(Optional.of(toAccountDetails));
//		when(transactionRepository.getTransactionHistory(123456789, 8, 2021)).thenReturn(transactionList);
//		transactionList.stream().forEach(history -> {
//			monthlyList = new MonthlyStatementResponseDTO();
//			BeanUtils.copyProperties(history, monthlyList);
//
//			monthList.add(monthlyList);
//		});
//		List<MonthlyStatementResponseDTO> result = transactionServiceImpl.getMonthlyStatement(123456789, 8, 2021);
//		assertEquals(monthList, result);
//	}
//
//	@Test
//	@DisplayName("Monthly statment:Negative Scenario")
//	public void MonthlyStatmentTest2() throws UserDefinedException {
//		when(accountRepository.findByAccountNumber(90909090)).thenThrow(UserDefinedException.class);
//		assertThrows(UserDefinedException.class, () -> transactionServiceImpl.getMonthlyStatement(90909090, 8, 2021));
//	}
//}
