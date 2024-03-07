package com.venkatesh.banking.service.impl;

import com.venkatesh.banking.dto.AccountDto;
import com.venkatesh.banking.entity.Account;
import com.venkatesh.banking.mapper.AccountMapper;
import com.venkatesh.banking.repository.AccountRepository;
import com.venkatesh.banking.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }
    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account= AccountMapper.mapToAccount(accountDto);
        Account savedAccount=accountRepository.save(account);


        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account=accountRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Account does not exist with given id") );
//        AccountDto accountDto=AccountMapper.mapToAccountDto(account);
//        return accountDto;
        return AccountMapper.mapToAccountDto(account);
    }
}
