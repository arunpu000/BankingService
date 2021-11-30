package com.banking.accountandfund.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.banking.accountandfund.dto.FundTransferRequestDTO;
import com.banking.accountandfund.dto.FundTransferViaPhoneRequest;
import com.banking.accountandfund.dto.StatementDTO;
import com.banking.accountandfund.exception.UserDefinedException;
import com.banking.accountandfund.service.FundTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/fundTransfer")
public class TransactionController {

	@Autowired
	private FundTransferService fundTransferService;
	
	@PostMapping("/fundTransferViaPhone")
	public ResponseEntity<Boolean> fundTransferViaPhone(@Valid @RequestBody FundTransferViaPhoneRequest fundTransferViaPhoneRequest)
			throws UserDefinedException {
		Boolean response = fundTransferService.transactionTransferViaPhone(fundTransferViaPhoneRequest);

		 return new ResponseEntity<Boolean>(response,HttpStatus.OK);

	}


	@PostMapping("/fundTransferViaAccount")
	public ResponseEntity<String> fundTransfer(@Valid @RequestBody FundTransferRequestDTO fundTransferRequestDTO)
			throws UserDefinedException {
		String response = fundTransferService.transactionTransfer(fundTransferRequestDTO);

		return new ResponseEntity<String>(response,HttpStatus.OK);

	}
	
	@GetMapping("/{accountNo}/{month}/{year}")
	public List<StatementDTO> getMonthStatement(@PathVariable @NotNull long accountNo,
												@PathVariable @NotNull @Min(1) @Max(12) int month,
												@PathVariable @NotNull int year ) throws UserDefinedException
	{
		List<StatementDTO> statementDTO = fundTransferService.getMonthlyStatementForAccount
				(accountNo,month,year);

		return statementDTO;
		
	}
}
