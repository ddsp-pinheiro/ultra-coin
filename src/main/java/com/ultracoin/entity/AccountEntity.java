package com.ultracoin.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="idt_account")
    private List<TransitionEntity> userTransactions;
}
