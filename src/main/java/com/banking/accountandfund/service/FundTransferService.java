package com.banking.accountandfund.service;

import java.util.List;

import com.banking.accountandfund.dto.FundTransferRequestDTO;
import com.banking.accountandfund.dto.FundTransferViaPhoneRequest;
import com.banking.accountandfund.dto.StatementDTO;
import com.banking.accountandfund.exception.UserDefinedException;

public interface FundTransferService {
	String transactionTransfer( FundTransferRequestDTO fundTransferRequestDTO) throws UserDefinedException;
	List<StatementDTO> getMonthlyStatementForAccount(long accountNo, int month, int year) throws UserDefinedException;
	Boolean transactionTransferViaPhone( FundTransferViaPhoneRequest fundTransferViaPhoneRequest) throws UserDefinedException;

}
