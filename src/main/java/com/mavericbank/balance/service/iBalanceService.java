package com.mavericbank.balance.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mavericbank.balance.model.Balance;

public interface iBalanceService {
	
	ResponseEntity<Balance> createBalance (Balance balance);
	
	Balance updateBalance (long balanceId, Balance balance);
	
	Balance getBalance (long balanceId);
	
	List<Balance> getBalances();
	
	ResponseEntity<Balance> deleteBalance(long balanceId);

}
