package com.banking.accountandfund.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserDefinedException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String exceptionMessage;

	public UserDefinedException(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

}
