package com.ultracoin.entity;

import com.ultracoin.AccountType;
import lombok.*;
import javax.persistence.*;
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
    @Id
    @Column(name = "idt_account")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "num_balance")
    @Builder.Default
    private BigDecimal totalBalance = BigDecimal.ZERO;
    @Column(name = "des_account_type")
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private AccountType accountType = AccountType.CHECKING_ACCOUNT;
    @Column(name = "num_account_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountNumber;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="idt_account")
    @Builder.Default
    private List<TransitionEntity> userTransactions=  new ArrayList<>();
    @Column(name = "idt_person")
    private Long idPerson;
}