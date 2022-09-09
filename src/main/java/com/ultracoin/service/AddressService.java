package com.ultracoin.service;

import com.ultracoin.entity.AddressEntity;
import com.ultracoin.exception.NotFoundException;
import com.ultracoin.repository.AddressRepository;
import com.ultracoin.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private static final String ID_NOT_FOUND = "Id not found";
    private final AddressRepository addressRepository;
    private final PersonService personService;

    public AddressEntity addAddress(AddressEntity addressEntity, Long id ){
//        if (addressRepository.findById(addressEntity.getId()).isPresent()){
//            throw new DuplicateKeyException("This card already exists");
//        }
        var addressOwner = personService.getById(id);
        addressEntity.setIdPerson(addressOwner.getId());
        addressOwner.setAddress(addressEntity);
        return addressRepository.save(addressEntity);
    }

    public AddressEntity getById(Long id){
        return addressRepository.findById(id).orElseThrow(() -> new NotFoundException(ID_NOT_FOUND));
    }
    public AddressEntity getByIdPerson(Long id){
        return addressRepository.findByIdPerson(id).orElseThrow(() -> new NotFoundException(ID_NOT_FOUND));
    }
}
