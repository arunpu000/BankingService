package com.banking.accountandfund.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@SequenceGenerator(name = "customer_id", sequenceName = "customer_sequence", initialValue = 100, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id")
	@Column(name = "id")
	private long customerId;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
		
	@Column(name = "age")
	private int age;
	
	@Column(name = "emailId")
	private String emailId;
	
	@Column(name = "phoneNumber")
	private Long phoneNumber;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "panNumber",unique=true)
	private String panNumber;

	@Column(name = "initialamount")
	private long initialamount;
}
