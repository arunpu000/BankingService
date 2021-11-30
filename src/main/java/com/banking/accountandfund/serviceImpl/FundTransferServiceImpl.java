package com.banking.accountandfund.serviceImpl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.banking.accountandfund.dto.FundTransferViaPhoneRequest;
import com.banking.accountandfund.dto.StatementDTO;
import com.banking.accountandfund.entity.Customer;
import com.banking.accountandfund.respositry.CustomerRepository;
import com.banking.accountandfund.respositry.FundTransferRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.banking.accountandfund.dto.FundTransferRequestDTO;
import com.banking.accountandfund.entity.Account;
import com.banking.accountandfund.entity.FundTransfer;
import com.banking.accountandfund.exception.UserDefinedException;
import com.banking.accountandfund.respositry.AccountRepository;
import com.banking.accountandfund.service.FundTransferService;

@Service
public class FundTransferServiceImpl implements FundTransferService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private FundTransferRepository fundTransferRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public String transactionTransfer(FundTransferRequestDTO fundTransferRequestDTO)
			throws UserDefinedException {

		// Fund Transfer object for Sending transaction
		FundTransfer sendFund = new FundTransfer();

		// Fund Transfer object for Receiving transaction
		FundTransfer receiveFund = new FundTransfer();

		// Sending Account details fetch from Account Table
		Optional<Account> sendAccount = accountRepository.findByAccountNumber
				(fundTransferRequestDTO.getFromAccount());
		// Sending Account Object
		Account sendAccountDetails = sendAccount.get();

		// Receiving Account details fetch from Account Table
		Optional<Account> receiveAccount = accountRepository.
				findByAccountNumber(fundTransferRequestDTO.getToAccount());
		//Receiving Account Object
		Account receiveAccountDetails = receiveAccount.get();

		// Checks for Sufficient Balance or not
		if ((sendAccountDetails.getCurrentBalance() > fundTransferRequestDTO.getAmount())) {

			// updating current balance and Saving data for account sending fund
			sendAccountDetails.setCurrentBalance(sendAccountDetails.getCurrentBalance()
					- fundTransferRequestDTO.getAmount());
			accountRepository.save(sendAccountDetails);

			// updating current balance and Saving amount for account receiving fund
			receiveAccountDetails.setCurrentBalance(receiveAccountDetails.getCurrentBalance()
					+ fundTransferRequestDTO.getAmount());
			accountRepository.save(receiveAccountDetails);

			sendFund.setAccountNo(sendAccountDetails.getAccountNumber());
			sendFund.setTransactionAccountNo(receiveAccountDetails.getAccountNumber());
			sendFund.setAmount(fundTransferRequestDTO.getAmount());
			sendFund.setCurrentBal(sendAccountDetails.getCurrentBalance());
			sendFund.setMessage(fundTransferRequestDTO.getRemarks());
			sendFund.setTransactionType("Debit");
			sendFund.setAccount(sendAccountDetails);
			sendFund.setTransactionDate(LocalDateTime.now());
			fundTransferRepository.save(sendFund);

			receiveFund.setAccountNo(receiveAccountDetails.getAccountNumber());
			receiveFund.setTransactionAccountNo(sendAccountDetails.getAccountNumber());
			receiveFund.setAmount(fundTransferRequestDTO.getAmount());
			receiveFund.setCurrentBal(receiveAccountDetails.getCurrentBalance());
			receiveFund.setMessage(fundTransferRequestDTO.getRemarks());
			receiveFund.setTransactionDate(LocalDateTime.now());
			receiveFund.setTransactionType("Credit");
			receiveFund.setAccount(receiveAccountDetails);
			fundTransferRepository.save(receiveFund);

			} else {
				throw new UserDefinedException("Balance is not enough");

			}
		return "Fund transfer  is done.";
	}


	@Override
	public List<StatementDTO> getMonthlyStatementForAccount(long accountNo, int month, int year)
			throws UserDefinedException {

		List<FundTransfer> fundTransferResponse = new ArrayList<FundTransfer>();
		List<StatementDTO> transactionDetails = new ArrayList<StatementDTO>();

		fundTransferResponse = fundTransferRepository.getTransactionDetails(accountNo, month, year);

		if (!fundTransferResponse.isEmpty())
		{
			fundTransferResponse.stream().forEach(fundTransferDetails -> {
				StatementDTO statement = new StatementDTO();
				BeanUtils.copyProperties(fundTransferDetails, statement);
				DateTimeFormatter formatter= DateTimeFormatter.
						ofPattern("dd-MM-yyyy HH:mm:ss");
				transactionDetails.add(statement);
			});
		}
		else
		{
			throw new UserDefinedException("No transaction details");
		}
		return transactionDetails;
	}

	@Override
	public Boolean transactionTransferViaPhone(FundTransferViaPhoneRequest fundTransferViaPhoneRequest) throws UserDefinedException {

		Boolean result = false;
		Customer fromCustomerSend = new Customer();

		Customer toCustomerReceive = new Customer();

		fromCustomerSend = customerRepository.findByPhoneNumber(
				fundTransferViaPhoneRequest.getPhoneNumber());

		toCustomerReceive =customerRepository.findByPhoneNumber(
				fundTransferViaPhoneRequest.getTransactionPhoneNumber());

		// Fund Transfer object for Sending transaction
		FundTransfer sendFund = new FundTransfer();

		// Fund Transfer object for Receiving transaction
		FundTransfer receiveFund = new FundTransfer();

		// Sending Account details fetch from Account Table
		Optional<Account> sendAccount = accountRepository.findByCustomerDetails
				(fromCustomerSend);
		// Sending Account Object
		Account sendAccountDetails = sendAccount.get();

		// Receiving Account details fetch from Account Table
		Optional<Account> receiveAccount = accountRepository.
				findByCustomerDetails(toCustomerReceive);
		//Receiving Account Object
		Account receiveAccountDetails = receiveAccount.get();

		// Checks for Sufficient Balance or not
		if ((sendAccountDetails.getCurrentBalance() > fundTransferViaPhoneRequest.getAmount())) {

			// updating current balance and Saving data for account sending fund
			sendAccountDetails.setCurrentBalance(sendAccountDetails.getCurrentBalance()
					- fundTransferViaPhoneRequest.getAmount());
			accountRepository.save(sendAccountDetails);

			// updating current balance and Saving amount for account receiving fund
			receiveAccountDetails.setCurrentBalance(receiveAccountDetails.getCurrentBalance()
					+ fundTransferViaPhoneRequest.getAmount());
			accountRepository.save(receiveAccountDetails);

			sendFund.setAccountNo(sendAccountDetails.getAccountNumber());
			sendFund.setTransactionAccountNo(receiveAccountDetails.getAccountNumber());
			sendFund.setAmount(fundTransferViaPhoneRequest.getAmount());
			sendFund.setCurrentBal(sendAccountDetails.getCurrentBalance());
			sendFund.setMessage(fundTransferViaPhoneRequest.getMessage());
			sendFund.setTransactionType("Debit");
			sendFund.setAccount(sendAccountDetails);
			sendFund.setTransactionDate(LocalDateTime.now());
			fundTransferRepository.save(sendFund);

			receiveFund.setAccountNo(receiveAccountDetails.getAccountNumber());
			receiveFund.setTransactionAccountNo(sendAccountDetails.getAccountNumber());
			receiveFund.setAmount(fundTransferViaPhoneRequest.getAmount());
			receiveFund.setCurrentBal(receiveAccountDetails.getCurrentBalance());
			receiveFund.setMessage(fundTransferViaPhoneRequest.getMessage());
			receiveFund.setTransactionDate(LocalDateTime.now());
			receiveFund.setTransactionType("Credit");
			receiveFund.setAccount(receiveAccountDetails);
			fundTransferRepository.save(receiveFund);
			result = true;
		} else {
			result = false;
			throw new UserDefinedException("Balance is not enough");
		}
		return result;
	}

}