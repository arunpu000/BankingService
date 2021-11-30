package com.banking.accountandfund.respositry;

import java.util.Optional;

import com.banking.accountandfund.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import com.banking.accountandfund.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	Optional<Account> findByAccountNumber(long accountNumber);
	Optional<Account> findByCustomerDetails(Customer customer);

}
