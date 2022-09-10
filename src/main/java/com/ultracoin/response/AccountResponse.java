package com.ultracoin.response;

import com.ultracoin.AccountType;
import com.ultracoin.entity.TransitionEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
public class AccountResponse {

    private Long id;
    private AccountType accountType;
    private BigDecimal totalBalance;
    private int accountNumber;
    private List<TransitionResponse> userTransactions;
    private Long idPerson;
}
