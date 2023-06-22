package com.mavericbank.balance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mavericbank.balance.model.Balance;
@Repository
public interface BalanceRepo extends JpaRepository<Balance, Long>{

}
