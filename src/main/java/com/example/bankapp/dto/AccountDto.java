package com.example.bankapp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {
    private  Long id;
    private  String clientName;
    private  double balance;


}
