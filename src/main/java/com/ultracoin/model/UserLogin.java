package com.ultracoin.model;

import lombok.*;


@Getter
@Setter
public class UserLogin {

    private Long id;
    private String email;
    private String senha;
    private String token;
}
