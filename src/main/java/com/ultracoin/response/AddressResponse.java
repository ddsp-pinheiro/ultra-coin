package com.ultracoin.response;

import com.ultracoin.States;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AddressResponse {
    private Long id;
    private String street;
    private int number;
    private String city;
    private States states;
    private String postalCode;
    private String country;
    private Long idPerson;
}
