package com.codercampus.Assignment11.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepo;

	public List<Transaction> findAll() {
		List<Transaction> transactions =  transactionRepo.findAll();
		Collections.sort(transactions, (transaction1, transaction2) -> transaction1.getDate().compareTo(transaction2.getDate())); 
		return transactions;
		
	}

	public Transaction findById(Long transactionId) {
		Optional<Transaction> transactionOpt = transactionRepo.findAll()
				  .stream()
				  .filter(transaction -> transaction.getId().equals(transactionId))
				  .findAny();
		return transactionOpt.orElse(new Transaction());
	}

}
