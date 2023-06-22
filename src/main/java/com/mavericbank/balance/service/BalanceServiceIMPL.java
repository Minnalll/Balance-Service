package com.mavericbank.balance.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mavericbank.balance.exception.ResourceNotFoundException;
import com.mavericbank.balance.model.Balance;
import com.mavericbank.balance.repository.BalanceRepo;
@Service
public class BalanceServiceIMPL implements iBalanceService{
	@Autowired
	private BalanceRepo repo;
	// Create Customer
	@Override
	public ResponseEntity<Balance> createBalance(Balance balance) {
		Balance save = repo.save(balance);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(save.getBalanceId())
				.toUri();   

		return ResponseEntity.created(location).build();		
	}
	// Update Balance
	@Override
	public Balance updateBalance(long balanceId, Balance balance) {
		return this.repo.findById(balanceId)
				.map(bal ->{
					if (null == balance.getAccountId()) {
					} else {
						bal.setAccountId(balance.getAccountId());
					}
					if (null == balance.getAmount()) {
					} else {
						bal.setAmount(balance.getAmount());
					}	
					if (null == balance.getCurrency()) {
					} else {
						bal.setCurrency(balance.getCurrency());
					}
					if (null == balance.getCreatedAt()) {
					} else {
						bal.setCreatedAt(balance.getCreatedAt());
					}
					if (null == balance.getUpdatedAt()) {
					} else {
						bal.setUpdatedAt(balance.getUpdatedAt());
					}
										
					return repo.save(bal);
				})
				.orElseThrow(()->new ResourceNotFoundException("Balance not found with id : " + balanceId));
		}
	
	// get one balance
	@Override
	public Balance getBalance(long balanceId) {
		 Balance findById = repo.findById(balanceId)
				 .orElseThrow(()->new ResourceNotFoundException("Balance not found with id : " + balanceId));
		 return findById;
	}
	// get all balances
	@Override
	public List<Balance> getBalances() {
		return repo.findAll();
	}
	// delete one balance
	@Override
	public ResponseEntity<Balance> deleteBalance(long balanceId) {
		Balance findById = this.repo.findById(balanceId)
				.orElseThrow(()-> new ResourceNotFoundException("Balance not found with id : " + balanceId));
		this.repo.deleteById(balanceId);
			
				return ResponseEntity.ok().build();
	}

}
