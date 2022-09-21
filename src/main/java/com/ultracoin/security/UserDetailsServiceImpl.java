package com.ultracoin.security;

import com.ultracoin.entity.PersonEntity;
import com.ultracoin.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<PersonEntity> personEntity = personRepository.findByEmail(email);

        if (personEntity.isPresent())
            return new UserDetailsImpl(personEntity.get());
        else
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
    }
}

