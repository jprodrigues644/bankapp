package com.example.bankapp.mapper;

import com.example.bankapp.dto.AccountDto;
import com.example.bankapp.entities.Account;


public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto){
        return new Account(accountDto.getId(),accountDto.getClientName(),accountDto.getBalance());
    }

    public static AccountDto mapToAccountDto(Account account){
        return new AccountDto(account.getId(),account.getClientName(),account.getBalance());
    }
}
