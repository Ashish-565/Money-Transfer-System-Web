package com.revature.repository;

import java.util.Date;
import java.util.List;

import com.revature.entity.*;

public interface TransactionRepository {

	void save(Transaction transaction);
	
	List<Transaction> getTransaction();
	
	List<Transaction> getTransaction(int limit);

	List<Transaction> getTransaction(Date fromDate, Date toDate);
	
}
