package com.banking.accountandfund.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Transaction")
public class FundTransfer {

	@Id
	@SequenceGenerator(name = "transaction_id", sequenceName = "transaction_sequence", initialValue = 300, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_id")
	@Column(name = "transactionId")
	private long transactionId;

	@Column(name = "transactionDate")
	private LocalDateTime transactionDate;

	@Column(name = "accountNo")
	private long accountNo;

	@Column(name = "transactionAccountNo")
	private long transactionAccountNo;

	@Column(name = "transactionType")
	private String transactionType;

	@Column(name = "amount")
	private Long amount;

	@Column(name = "currentBal")
	private Long currentBal;

	@Column(name = "message")
	private String message;
	
	@ManyToOne
	private Account account; 
}
