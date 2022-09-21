package com.ultracoin.service;

import com.ultracoin.entity.TransitionEntity;
import com.ultracoin.exception.NotFoundException;
import com.ultracoin.repository.TransitionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class TransitionService {
    private static final String ID_NOT_FOUND = "Id not found";
    public final TransitionRepository transitionRepository;
    public final AccountService accountService;

    public TransitionEntity addNewTransition(TransitionEntity transitionEntity, Long idAccount){
        var account =accountService.getById(idAccount);
        switch (transitionEntity.getType()) {
            case DEPOSIT:
                account.setTotalBalance(account.getTotalBalance().add(transitionEntity.getValue()));
                break;

            case WITHDRAW:
                if(account.getTotalBalance().compareTo( transitionEntity.getValue()) == 1) {
                    account.setTotalBalance(account.getTotalBalance().subtract(transitionEntity.getValue()));
                } else {
                    throw new RuntimeException("Insufficient balance");
                }
                break;

            case TRANSFER:
                account.setTotalBalance(account.getTotalBalance().subtract(transitionEntity.getValue()));
                break;
//            default:

        }

        transitionEntity.setDate(LocalDateTime.now());
        transitionEntity.setIdAccount(idAccount);
        return transitionRepository.save(transitionEntity);
    }

    public TransitionEntity getById(Long id) {
        return transitionRepository.findById(id).orElseThrow(() -> new NotFoundException(ID_NOT_FOUND));
    }
}
