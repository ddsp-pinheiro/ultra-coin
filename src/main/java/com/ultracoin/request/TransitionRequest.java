package com.ultracoin.request;

import com.ultracoin.TransitionType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class TransitionRequest {

    private BigDecimal value;
    private String description;
    private TransitionType type;

}
