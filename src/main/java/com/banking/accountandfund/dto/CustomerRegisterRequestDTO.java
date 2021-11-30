package com.banking.accountandfund.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegisterRequestDTO {

	
	@NotEmpty(message = "firstName should not be empty")
	@Size(min = 3, max = 20, message = " firstName  3 to 20 charcter")
	private String firstName;

	@NotEmpty(message = "lastName should not be empty")
	@Size(min = 3, max = 20, message = " lastName 3 to 20 character")
	private String lastName;

	@NotEmpty(message = "emailId should not be empty")
	@Email
	@Size(min = 5, max = 100, message = "EmailId 100 character")
	private String emailId;

	@NotEmpty(message = "Please provide a Mobile Number")
	@Size(max = 10, message = "phone number is of 10 digits")
	private String phoneNumber;

	@NotEmpty(message = "gender should not be empty")
	private String gender;

	@NotEmpty(message = "PanNumber should not be empty")
	@Size(max = 10, message = "PanNumber 10 character")
	private String panNumber;


	@NotNull(message = "Age should not be empty")
	@Min(18)
	private int age;

	@NotNull
	private Long initialamount;
}
