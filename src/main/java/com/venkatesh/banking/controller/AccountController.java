package com.venkatesh.banking.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.venkatesh.banking.dto.AccountDto;
import com.venkatesh.banking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    // Get All Accounts REST API
    @GetMapping
//    public List<AccountDto> getAllAccounts(){
//        return accountService.getAllAccounts();
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> accounts= accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);

    }
    // Deposit REST API
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String,Double> request){
        Double depositAmount=request.get("depositAmount");
        AccountDto accountDto=accountService.deposit(id,depositAmount);
        return ResponseEntity.ok(accountDto);
    }
    // Withdraw REST API
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,@RequestBody Map<String,Double> req){
        Double withdrawAmount=req.get("withdrawAmount");
        return ResponseEntity.ok(accountService.withdraw(id,withdrawAmount));
    }
    // Delete Account REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return new ResponseEntity<>("Account deleted with id:"+id,HttpStatus.OK);

    }

}
