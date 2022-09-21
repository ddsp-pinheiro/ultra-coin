package com.ultracoin.controller;

import com.ultracoin.entity.AddressEntity;
import com.ultracoin.mapper.AddressMapper;
import com.ultracoin.request.AddressRequest;
import com.ultracoin.response.AddressResponse;
import com.ultracoin.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/person/address")
@RequiredArgsConstructor
public class AddressContoller {
    private final AddressService addressService;
    private final AddressMapper addressMapper;
    private static final String ID = "x-id";

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public AddressResponse postAddress(@Valid @RequestBody AddressRequest addressRequest, @RequestHeader(ID) Long id){
        AddressEntity entitySaved = addressService.getById(id);
        AddressEntity entity = addressService.addAddress(addressMapper.toEntity(entitySaved, addressRequest),id);
        return addressMapper.toResponse(entity);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AddressResponse getAddressById(@PathVariable Long id){
        AddressEntity entity = addressService.getById(id);
        return addressMapper.toResponse(entity);
    }
    @GetMapping("user/{idPerson}")
    @ResponseStatus(HttpStatus.OK)
    public AddressResponse getAddressByPersonId(@PathVariable Long idPerson){
        AddressEntity entity = addressService.getByIdPerson(idPerson);
        return addressMapper.toResponse(entity);
    }

}
