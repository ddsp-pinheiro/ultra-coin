package com.ultracoin.request;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PersonRequest {
    private String name;
    private String email;
    private String password;
    private String taxId;
    private int areaCode;
    private Long phoneNumber;
    private Date birthDate;
    private List<AccountRequest> userAccounts;
}
