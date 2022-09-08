package com.ultracoin.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "transition_entity")
public class TransitionEntity {
    @Column(name = "idt_transition")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private BigDecimal value;
    @Column
    private String description;
    @Column
    private LocalDateTime date;
}
