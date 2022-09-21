package com.ultracoin.request;

import com.ultracoin.enums.AccountType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountRequest {

    private AccountType accountType;
    private Long idPerson;
}
