package com.ultracoin.entity;


import lombok.*;
import org.apache.tomcat.jni.Address;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import java.util.Date;

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
    @Column(name = "dat_birth_date")
    private Date birthDate ;
    @Column
    private AddressEntity address;


}
