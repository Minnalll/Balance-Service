package com.mavericbank.balance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mavericbank.balance.model.Balance;
import com.mavericbank.balance.service.BalanceServiceIMPL;

@RestController
@RequestMapping("/balance")
public class BalanceController {
	@Autowired
	private BalanceServiceIMPL service;
	// Create 
	@PostMapping("/create")
	public ResponseEntity<Balance> createUser (@RequestBody Balance balance) {
		return service.createBalance(balance);
	}
	// Find One
	@GetMapping("/find/{id}")
	public Balance retrieveBalance(@PathVariable long id) {
		return service.getBalance(id);
	}
	// Find All
	@GetMapping("/find")
	public List<Balance> retrieveAllBalance() {
		return service.getBalances();
	}
	// Update
	@PutMapping("/update/{id}")
	public Balance updateBalance(@PathVariable long id, @RequestBody Balance balance) {
		return service.updateBalance(id, balance);	
	}
	// Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Balance> deleteBalance (@PathVariable long id) {	
		return service.deleteBalance(id);
	}
}
