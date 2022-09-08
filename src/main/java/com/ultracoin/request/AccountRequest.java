package com.ultracoin.request;

import com.ultracoin.entity.TransitionEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class AccountRequest {

    private BigDecimal totalBalance;
    private Long numberAccount;
    private List<TransitionEntity> userTransactions;
    private Long idPerson;
}
