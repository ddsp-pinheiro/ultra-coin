package com.ultracoin.entity;

import lombok.*;


@Getter
@Setter
public class UserLoginEntity {

    private Long id;
    private String email;
    private String senha;
    private String token;
}
