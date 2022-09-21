package com.ultracoin.request;

import com.ultracoin.enums.TransitionType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransitionRequest {

    private BigDecimal value;
    private String description;
    private TransitionType type;

}
