package com.ultracoin.response;

import com.ultracoin.entity.AddressEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
public class PersonResponse {

    private Long id;
    private Long taxId;
    private String name;
    private int areaCode;
    private Long phoneNumber;
    private Date birthDate;
    private AddressResponse address;
    private List<AccountResponse> userAccounts;
}
