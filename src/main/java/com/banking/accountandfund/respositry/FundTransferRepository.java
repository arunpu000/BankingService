package com.banking.accountandfund.respositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.banking.accountandfund.entity.FundTransfer;

public interface FundTransferRepository extends JpaRepository<FundTransfer, Long> {

	//List<FundTransfer> findByAccount_noAndTransaction_dateBetween(long accountNo, date start, date end);

	@Query("from FundTransfer where accountNo=:accountNo and month(transactionDate)=:month and year(transactionDate)=:year order by transactionDate desc")
	List<FundTransfer> getTransactionDetails(long accountNo, int month, int year);

}
