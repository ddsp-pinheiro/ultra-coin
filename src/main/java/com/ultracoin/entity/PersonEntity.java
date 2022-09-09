package com.ultracoin.entity;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PERSON_ENTITY")
public class PersonEntity {
    @Id
    @Column(name = "idt_person")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "num_taxId")
    private Long taxId;
    @Column(name = "nam_full_name")
    private String name;
    @Column(name = "num_area_code")
    private int areaCode;
    @Column(name = "num_phone_number")
    private Long phoneNumber;
    @Column(name = "dat_birth_date")
    private Date birthDate ;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idt_person")
    @Builder.Default
    private AddressEntity address = new AddressEntity();
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="idt_person")
    @Builder.Default
    private List<AccountEntity> userAccounts = new ArrayList<>();

}
