package com.venkatesh.banking.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.venkatesh.banking.dto.AccountDto;
import com.venkatesh.banking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    final private AccountService accountService;
    public AccountController(AccountService accountService){
        this.accountService=accountService;
    }
    // Add Account REST API
    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }
    // Get Account REST API
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
//        return new ResponseEntity<>(accountService.getAccountById(id),HttpStatus.OK);
        AccountDto accountDto=accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

}
