package com.ultracoin.service;

import com.ultracoin.entity.PersonEntity;
import com.ultracoin.exception.NotFoundException;
import com.ultracoin.model.UserLogin;
import com.ultracoin.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PersonService {

    private static final String CPF_NOT_FOUND = "Account number not found";
    private static final String ID_NOT_FOUND = "Person not found";
    private final PersonRepository personRepository;

    public Optional<PersonEntity> register(PersonEntity personEntity) {

        if (personRepository.findByEmail(personEntity.getEmail()).isPresent()) {
            return Optional.empty();
        }
        personEntity.setPassword(encryptPassword(personEntity.getPassword()));

        return Optional.of(personRepository.save(personEntity));

    }

    public Optional<UserLogin> authentication(Optional<UserLogin> userLogin) {

        Optional<PersonEntity> personEntity = personRepository.findByEmail(userLogin.get().getEmail());

        if (personEntity.isPresent() && comparePassword(userLogin.get().getPassword(), personEntity.get().getPassword())) {
            userLogin.get().setId(personEntity.get().getId());
            userLogin.get().setEmail(personEntity.get().getEmail());
            userLogin.get().setToken(generateBasicToken(userLogin.get().getEmail(), userLogin.get().getPassword()));
            userLogin.get().setPassword(personEntity.get().getPassword());
            return userLogin;

        }

        return Optional.empty();

    }

    private String encryptPassword(String password) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return encoder.encode(password);

    }

    private boolean comparePassword(String password, String passwordDb) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return encoder.matches(password, passwordDb);

    }

    private String generateBasicToken(String email, String password) {

        String token = email + ":" + password;
        byte[] tokenBase64 = Base64.encodeBase64(token.getBytes(Charset.forName("US-ASCII")));
        return "Basic " + new String(tokenBase64);

    }

    public PersonEntity addUser(PersonEntity personEntity) {
        boolean isNew = !Optional.ofNullable(personEntity.getId()).isPresent();
        if(isNew) {
//            if (personRepository.findById(personEntity.getId()).isPresent()) {
//                throw new DuplicateKeyException("This user already exists");
//            }
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

    public PersonEntity getById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new NotFoundException(ID_NOT_FOUND));
    }

    public PersonEntity getByTaxId(String taxId){
        return personRepository.findByTaxId(taxId).orElseThrow(() -> new NotFoundException(CPF_NOT_FOUND));
    }
}
