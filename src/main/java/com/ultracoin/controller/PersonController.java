package com.ultracoin.controller;

import com.ultracoin.entity.AddressEntity;
import com.ultracoin.entity.PersonEntity;
import com.ultracoin.mapper.PersonMapper;
import com.ultracoin.request.PersonRequest;
import com.ultracoin.response.PersonResponse;
import com.ultracoin.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;
    private final PersonMapper personMapper;

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
