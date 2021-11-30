package com.banking.accountandfund.dto;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FundTransferRequestDTO {

	@NotNull(message="please enter Account from money get deduct")
	private long fromAccount;
	
	@NotNull(message="please enter account in which money will add")
	private long toAccount;
	
	@NotNull(message="please enter amount to be send")
	@Min(1)
	@Max(50000)
	private Long amount;
	
	private String remarks;

	
}
