package com.ultracoin.service;

import com.ultracoin.entity.PersonEntity;
import com.ultracoin.model.UserLogin;
import com.ultracoin.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PersonRepository personRepository;


}
