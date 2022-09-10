package com.ultracoin.request;

import com.ultracoin.AccountType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountRequest {

    private AccountType accountType;
    private Long idPerson;
}
