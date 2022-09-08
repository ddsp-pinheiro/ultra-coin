package com.ultracoin.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TRANSITION_ENTITY")
public class TransitionEntity {
    @Column(name = "idt_transition")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "num_value")
    private BigDecimal value;
    @Column(name = "des_transition_description")
    private String description;
    @NotNull
    @Column(name = "dat_date_create")
    private LocalDateTime date;
}
