package com.banking.accountandfund.dto;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// Response dto
public class StatementDTO {
	private long transactionId;

	private LocalDateTime transactionDate;

	private long accountNo;

	private String transactionType;

	private long transactionAccountNo;

	private Long amount;

	private Long currentBal;

	private String desc;
	
	

}
