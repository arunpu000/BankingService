package com.banking.accountandfund.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FundTransferViaPhoneRequest {

    @NotNull(message="please enter phone from money get deduct")
    private Long phoneNumber;

    @NotNull(message="please enter account in which money will add")
    private Long transactionPhoneNumber;

    @NotNull(message="please enter amount to be send")
    @Min(1)
    @Max(50000)
    private Long amount;

    private String message;
}
