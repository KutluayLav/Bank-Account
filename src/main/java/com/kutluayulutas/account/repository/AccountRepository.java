package com.kutluayulutas.account.repository;

import com.kutluayulutas.account.modal.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {

    

}
