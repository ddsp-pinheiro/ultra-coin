package com.ultracoin.request;

import com.ultracoin.entity.AddressEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PersonRequest {
    private Long taxId;
    private String name;
    private int areaCode;
    private Long phoneNumber;
    private Date birthDate;
    private AddressRequest address;
    private List<AccountRequest> userAccounts;
}
