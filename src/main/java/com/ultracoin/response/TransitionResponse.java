package com.ultracoin.response;

import com.ultracoin.enums.TransitionType;
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
    private TransitionType type;
    private String description;
    private LocalDateTime date;
    private Long idAccount;
}
