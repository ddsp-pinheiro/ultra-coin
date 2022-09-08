package com.ultracoin.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "address_entity")
public class AddressEntity {
    @Column
    private String street;
    @Column
    private int number;
    @Column
    private String city;
    @Column
    private States states;
    @Column
    private String postalCode;
    @Column
    private String country;
}
