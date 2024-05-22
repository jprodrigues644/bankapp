package com.example.bankapp.services.implementation;

import com.example.bankapp.mapper.AccountMapper;
import com.example.bankapp.dto.AccountDto;
import com.example.bankapp.entities.Account;
import com.example.bankapp.repository.AccountRepository;
import com.example.bankapp.services.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImplementation implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImplementation(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount =  accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }


    @Override
    public AccountDto getAccountByID(Long id){
      Account account = accountRepository
              .findById(id)
              .orElseThrow(()->new RuntimeException("Account does not exist"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Account does not exist"));
        double balance_total = account.getBalance() + amount;
        account.setBalance(balance_total);
        Account savedAccount =  accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Account does not exist"));
        if(account.getBalance()<amount){
            throw new RuntimeException("Balance insufficient");
        }
        double balance_total = account.getBalance() - amount;
        account.setBalance(balance_total);
        Account savedAccount =  accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }


}

