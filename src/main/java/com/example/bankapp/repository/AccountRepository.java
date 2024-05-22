package com.example.bankapp.repository;

import com.example.bankapp.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

//Crud Actions to perform in the Account Table
public interface AccountRepository extends JpaRepository <Account, Long> {


}
