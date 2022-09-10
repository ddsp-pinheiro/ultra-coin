package com.ultracoin.request;

import com.ultracoin.States;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequest {

    private String street;
    private int number;
    private String city;
    private States states;
    private String postalCode;
    private String country;
    private Long idPerson;
}