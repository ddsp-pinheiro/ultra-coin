package com.ultracoin.mapper;

import com.ultracoin.entity.AccountEntity;
import com.ultracoin.request.AccountRequest;
import com.ultracoin.response.AccountResponse;
import com.ultracoin.response.TransitionResponse;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class AccountMapper {
    public AccountEntity toEntity(AccountRequest accountRequest) {
        return AccountEntity.builder()
                .accountType(accountRequest.getAccountType())
                .build();
    }

    public AccountResponse toResponse(AccountEntity accountEntity) {
        return AccountResponse.builder()
                .id(accountEntity.getId())
                .idPerson(accountEntity.getIdPerson())
                .accountType(accountEntity.getAccountType())
                .accountNumber(accountEntity.getAccountNumber())
                .totalBalance(accountEntity.getTotalBalance())
                .userTransactions(accountEntity.getUserTransactions().stream().map(transitionResponse -> TransitionResponse.builder()
                        .id(transitionResponse.getId())
                        .date(transitionResponse.getDate())
                        .value(transitionResponse.getValue())
                        .description(transitionResponse.getDescription())
                        .type(transitionResponse.getType())
                        .idAccount(transitionResponse.getIdAccount())
                        .build()).collect(Collectors.toList()))
                .build();
    }
}
