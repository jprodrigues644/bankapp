package com.example.bankapp.services;

import com.example.bankapp.dto.AccountDto;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountByID(Long id);

    AccountDto deposit(Long id , double amount);

    AccountDto withdraw (Long id, double amount);

}
