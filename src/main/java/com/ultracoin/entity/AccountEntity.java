package com.ultracoin.entity;

import lombok.*;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "account_entity")
public class AccountEntity {

    private BigDecimal balance;
    private Long numberAccount;
}
