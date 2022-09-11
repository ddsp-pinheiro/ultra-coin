package com.ultracoin.service;

import com.ultracoin.entity.TransitionEntity;
import com.ultracoin.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private static final String ID_NOT_FOUND = "Id not found";
    public final TransactionRepository transactionRepository;
    public final AccountService accountService;

    public TransitionEntity addNewTransition(TransitionEntity transitionEntity){
        return transitionEntity;
    }
}
