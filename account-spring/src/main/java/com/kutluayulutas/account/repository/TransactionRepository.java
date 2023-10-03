package com.kutluayulutas.account.repository;

import com.kutluayulutas.account.modal.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,String> {

}
