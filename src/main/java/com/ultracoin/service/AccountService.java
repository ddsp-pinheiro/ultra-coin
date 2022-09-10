package com.ultracoin.service;

import com.ultracoin.entity.AccountEntity;
import com.ultracoin.exception.NotFoundException;
import com.ultracoin.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AccountService {
    private static final String ID_NOT_FOUND = "Id not found";
    private static final String ACCOUNT_NUMBER_NOT_FOUND = "Account number not found";

    private final AccountRepository accountRepository;
    private final PersonService personService;
    private final SecureRandom random = new SecureRandom();

    public AccountEntity createNewAccount(AccountEntity accountEntity, Long id){
        accountEntity.setAccountNumber(random.nextInt(Integer.MAX_VALUE-1));
        accountEntity.setIdPerson(id);
        return accountRepository.save(accountEntity);
    }

    public AccountEntity getById(Long id){
        return accountRepository.findById(id).orElseThrow(() -> new NotFoundException(ID_NOT_FOUND));
    }

    public AccountEntity getByAccountNumber(int accountNumber){
        return accountRepository.findByAccountNumber(accountNumber).orElseThrow(() -> new NotFoundException(ACCOUNT_NUMBER_NOT_FOUND));
    }

}
