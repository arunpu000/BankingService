package com.banking.accountandfund.respositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.accountandfund.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long>{
Customer findByPanNumber(String panNumber);
Customer findByPhoneNumber(Long phoneNumber);
}
