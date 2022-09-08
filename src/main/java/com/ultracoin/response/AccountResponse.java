package com.ultracoin.response;

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
    private BigDecimal totalBalance;
    private Long numberAccount;
    private List<TransitionResponse> userTransactions;
    private Long idPerson;
}
