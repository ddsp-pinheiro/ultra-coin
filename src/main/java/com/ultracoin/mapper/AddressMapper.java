package com.ultracoin.mapper;

import com.ultracoin.entity.AddressEntity;
import com.ultracoin.request.AddressRequest;
import com.ultracoin.response.AddressResponse;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AddressMapper {

    public AddressEntity toEntity(AddressRequest addressRequest) {
        return AddressEntity.builder()
                .number(addressRequest.getNumber())
                .street(addressRequest.getStreet())
                .states(addressRequest.getStates())
                .postalCode(addressRequest.getPostalCode())
                .city(addressRequest.getCity())
                .country(addressRequest.getCountry())
                .build();
    }
    public AddressEntity toEntity(AddressEntity addressEntitySaved, AddressRequest addressRequest) {
        addressEntitySaved.setIdPerson(Optional.ofNullable(addressRequest.getIdPerson()).orElse(addressEntitySaved.getIdPerson()));
        addressEntitySaved.setCity(Optional.ofNullable(addressRequest.getCity()).orElse(addressEntitySaved.getCity()));
        addressEntitySaved.setCountry(Optional.ofNullable(addressRequest.getCountry()).orElse(addressEntitySaved.getCountry()));
        addressEntitySaved.setNumber(Optional.ofNullable(addressRequest.getNumber()).orElse(addressEntitySaved.getNumber()));
        addressEntitySaved.setPostalCode(Optional.ofNullable(addressRequest.getPostalCode()).orElse(addressEntitySaved.getPostalCode()));
        addressEntitySaved.setStates(Optional.ofNullable(addressRequest.getStates()).orElse(addressEntitySaved.getStates()));
        addressEntitySaved.setStreet(Optional.ofNullable(addressRequest.getStreet()).orElse(addressEntitySaved.getStreet()));
        return addressEntitySaved;
    }

    public AddressResponse toResponse(AddressEntity personEntity) {
        return AddressResponse.builder()
                .id(personEntity.getId())
                .idPerson(personEntity.getIdPerson())
                .city(personEntity.getCity())
                .country(personEntity.getCountry())
                .states(personEntity.getStates())
                .street(personEntity.getStreet())
                .number(personEntity.getNumber())
                .postalCode(personEntity.getPostalCode())
                .build();
    }
}
