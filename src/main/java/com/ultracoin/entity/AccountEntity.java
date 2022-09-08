package com.ultracoin.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ACCOUNT_ENTITY")
public class AccountEntity {

    @Column(name = "idt_account")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "num_balance")
    private BigDecimal balance;
    @NotNull
    @Column(name = "num_number_account")
    private Long numberAccount;
}
