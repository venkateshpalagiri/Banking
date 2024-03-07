package com.venkatesh.banking.service;

import com.venkatesh.banking.dto.AccountDto;
import com.venkatesh.banking.entity.Account;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(Long id);
    AccountDto deposit(Long id,double depositAmount);
    AccountDto withdraw(Long id,double withdrawAmount);
    List<AccountDto> getAllAccounts();
    void deleteAccount(Long id);

}
