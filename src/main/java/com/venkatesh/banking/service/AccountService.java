package com.venkatesh.banking.service;

import com.venkatesh.banking.dto.AccountDto;
import com.venkatesh.banking.entity.Account;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(Long id);
}
