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
@Entity(name = "person_entity")
public class PersonEntity {

    @Column(name = "idt_person")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @NotNull
    private String name;
    @Column
    private int areaCode;
    @Column
    private Long phoneNumber;
    @Column
    private AddressEntity address;
    @Column
    @NotNull
    private Long cpf;

}
