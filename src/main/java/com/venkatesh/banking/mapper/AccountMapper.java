package com.venkatesh.banking.mapper;

import com.venkatesh.banking.dto.AccountDto;
import com.venkatesh.banking.entity.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto){
        Account account=new Account(
                accountDto.getId(),
                accountDto.getAccountHolder(),
                accountDto.getBalance()
        );
        return account;
    }
    public static AccountDto mapToAccountDto(Account account){
        AccountDto accountDto=new AccountDto(
                account.getId(),
                account.getAccountHolder(),
                account.getBalance()
        );
        return accountDto;
    }
}
