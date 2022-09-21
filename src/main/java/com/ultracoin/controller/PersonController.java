package com.ultracoin.controller;

import com.ultracoin.entity.PersonEntity;
import com.ultracoin.mapper.PersonMapper;
import com.ultracoin.model.UserLogin;
import com.ultracoin.request.PersonRequest;
import com.ultracoin.response.PersonResponse;
import com.ultracoin.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;
    private final PersonMapper personMapper;

    @PostMapping("/login")
    public ResponseEntity<UserLogin> login(@RequestBody Optional<UserLogin> userLogin) {
        return personService.authentication(userLogin)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @PostMapping("/register")
    public ResponseEntity<PersonEntity> registerPerson(@Valid @RequestBody PersonEntity personEntity) {
        return personService.register(personEntity)
                .map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(resp))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonResponse post(@Valid @RequestBody PersonRequest personRequest) {
        PersonEntity entity = personService.addUser(personMapper.toEntity(personRequest));
        return personMapper.toResponseToPost(entity);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonResponse getId(@PathVariable Long id) {
        PersonEntity entity = personService.getById(id);
        return personMapper.toResponse(entity);
    }

    @GetMapping("/taxId/{taxId}")
    @ResponseStatus(HttpStatus.OK)
    public PersonResponse getTaxId(@PathVariable String taxId) {
        PersonEntity entity = personService.getByTaxId(taxId);
        return personMapper.toResponse(entity);
    }
}
