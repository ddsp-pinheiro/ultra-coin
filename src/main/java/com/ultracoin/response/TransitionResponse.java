package com.ultracoin.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class TransitionResponse {
    private Long id;
    private BigDecimal value;
    private String description;
    private LocalDateTime date;
    private Long idAccount;
}
