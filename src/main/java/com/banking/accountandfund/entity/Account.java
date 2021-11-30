package com.banking.accountandfund.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/*import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;*/
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class Account {
	@Id
	@SequenceGenerator(name = "account_id", sequenceName = "account_sequence", initialValue = 200, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_id")
	@Column(name = "id")
	private long accountId;
	
	private long accountNumber;
	private Long openingBalance;
	private Long currentBalance;

	@Column(name = "creationDate")
	private LocalDateTime creationDate;

	@OneToOne
	@JoinColumn(name = "customerId")
	private Customer customerDetails;

}
