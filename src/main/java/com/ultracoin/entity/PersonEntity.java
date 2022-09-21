package com.ultracoin.entity;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Collection;
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
    @Column(name = "des_password")
    private String password;
    @Column(name = "des_email")
    @Email
    private String email;
    @Column(name = "num_taxId")
    @CPF(message = "Tax id invalid")
    private String taxId;
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
    private List<AccountEntity> userAccounts;
}
