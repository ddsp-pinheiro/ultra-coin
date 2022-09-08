package com.ultracoin.entity;


import lombok.*;
import org.apache.tomcat.jni.Address;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PERSON_ENTITY")
public class PersonEntity {

    @Column(name = "idt_person")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "num_tax_id")
    private Long taxId;
    @NotNull
    @Column(name = "nam_full_name")
    private String name;
    @Column(name = "num_area_code")
    private int areaCode;
    @Column(name = "num_phone_number")
    private Long phoneNumber;
    @Column
    private AddressEntity address;


}
