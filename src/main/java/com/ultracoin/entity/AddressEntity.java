package com.ultracoin.entity;

import com.ultracoin.States;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ADDRESS_ENTITY")
public class AddressEntity {
    @Column(name = "des_street")
    private String street;
    @Column(name = "num_number")
    private int number;
    @Column(name = "des_city")
    private String city;
    @Enumerated(EnumType.STRING)
    @Column(name = "des_states")
    private States states;
    @Column(name = "num_postal_code")
    private String postalCode;
    @Column(name = "des_country")
    private String country;
}
