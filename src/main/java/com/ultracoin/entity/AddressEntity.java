package com.ultracoin.entity;

import com.ultracoin.States;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ADDRESS_ENTITY")
public class AddressEntity {
    @Id
    @Column(name = "idt_address")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    @Column(name = "idt_person")
    private Long idPerson;
}
