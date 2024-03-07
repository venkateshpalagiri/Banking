package com.venkatesh.banking.service.impl;

import com.venkatesh.banking.dto.AccountDto;
import com.venkatesh.banking.entity.Account;
import com.venkatesh.banking.mapper.AccountMapper;
import com.venkatesh.banking.repository.AccountRepository;
import com.venkatesh.banking.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public AccountDto deposit(Long id, double depositAmount) {
        Account account=accountRepository
                .findById(id).orElseThrow(()->new RuntimeException("Account not found with given id"));
        account.setBalance(account.getBalance()+depositAmount);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double withdrawAmount) {
        Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account not found with the id given"));
        if(account.getBalance()<withdrawAmount){
            throw new RuntimeException("Insufficient balance");
        }
        account.setBalance(account.getBalance()-withdrawAmount);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts=accountRepository.findAll();

//        return accounts.stream().map((account -> AccountMapper.mapToAccountDto(account)))
//                .collect(Collectors.toList());
        List<AccountDto> accountDtoList=accounts.stream().map((account -> AccountMapper.mapToAccountDto(account)))
                .collect(Collectors.toList());
        return accountDtoList;
    }

    @Override
    public void deleteAccount(Long id) {
        Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account not found with the id given"));
//        accountRepository.deleteById(id);
        accountRepository.delete(account);
    }
}
