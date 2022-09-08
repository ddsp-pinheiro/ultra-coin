package com.ultracoin.request;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class TransitionRequest {

    private BigDecimal value;
    private String description;
    private LocalDateTime date;
    private Long idAccount;
}
