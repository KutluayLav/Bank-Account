package com.kutluayulutas.account.repository;

import com.kutluayulutas.account.modal.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {

}
