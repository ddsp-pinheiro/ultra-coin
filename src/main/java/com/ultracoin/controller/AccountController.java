package com.ultracoin.controller;

import com.ultracoin.entity.AccountEntity;
import com.ultracoin.mapper.AccountMapper;
import com.ultracoin.request.AccountRequest;
import com.ultracoin.response.AccountResponse;
import com.ultracoin.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final AccountMapper accountMapper;
    private static final String ID = "x-id";

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountResponse postNewAccount(@Valid @RequestBody AccountRequest accountRequest, @RequestHeader(ID) Long id){
        AccountEntity entity =accountService.createNewAccount(accountMapper.toEntity(accountRequest), id);
        return accountMapper.toResponse(entity);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountResponse getAccountById(@PathVariable Long id){
        AccountEntity entity= accountService.getById(id);
        return accountMapper.toResponse(entity);
    }

    @GetMapping("/getByNumber/{accountNumber}")
    @ResponseStatus(HttpStatus.OK)
    public AccountResponse getAccountByNumber(@PathVariable int accountNumber){
        AccountEntity entity= accountService.getByAccountNumber(accountNumber);
        return accountMapper.toResponse(entity);
    }
}
