package com.ultracoin.service;

import com.ultracoin.entity.AddressEntity;
import com.ultracoin.entity.PersonEntity;
import com.ultracoin.exception.NotFoundException;
import com.ultracoin.repository.AddressRepository;
import com.ultracoin.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PersonService {

    private static final String CPF_NOT_FOUND = "Account number not found";
    private static final String ID_NOT_FOUND = "Person not found";
    private final PersonRepository personRepository;

    public PersonEntity addUser(PersonEntity personEntity) {
        boolean isNew = !Optional.ofNullable(personEntity.getId()).isPresent();
        if(isNew) {
//            if (personRepository.findById(personEntity.getId()).isPresent()) {
//                throw new DuplicateKeyException("This user already exists");
//            }
        }

        if (Boolean.FALSE.equals(verifyTaxId(personEntity.getTaxId()))) {
            throw new RuntimeException("The tax id entered is invalid");
        }
        return savePersonInDatabase(personEntity);
    }

    public PersonEntity savePersonInDatabase(PersonEntity entity){
        try {
            return personRepository.save(entity);
        }catch (JpaSystemException e){
            log.error("Message={}",e.getMessage());
            throw new JpaSystemException(e);
        }
    }

    public PersonEntity addAddressToUser(Long id, AddressEntity addressEntity) {
        PersonEntity entity = getById(id);
        entity.setAddress(addressEntity);
        return personRepository.save(entity);
    }

    private Boolean verifyTaxId(Long taxId) {
        return taxId > 10000000000L && taxId < 99999999999L;
    }

    public PersonEntity getById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new NotFoundException(ID_NOT_FOUND));
    }

    public PersonEntity getByTaxId(Long taxId){
        return personRepository.findByTaxId(taxId).orElseThrow(() -> new NotFoundException(CPF_NOT_FOUND));
    }
}
