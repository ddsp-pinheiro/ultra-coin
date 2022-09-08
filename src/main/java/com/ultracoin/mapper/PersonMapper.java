package com.ultracoin.mapper;

import com.ultracoin.entity.AccountEntity;
import com.ultracoin.entity.AddressEntity;
import com.ultracoin.entity.PersonEntity;
import com.ultracoin.entity.TransitionEntity;
import com.ultracoin.request.AddressRequest;
import com.ultracoin.request.PersonRequest;
import com.ultracoin.response.AccountResponse;
import com.ultracoin.response.AddressResponse;
import com.ultracoin.response.PersonResponse;
import com.ultracoin.response.TransitionResponse;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PersonMapper {
    public PersonEntity toEntity(PersonRequest personRequest) {
        return PersonEntity.builder()
                .name(personRequest.getName())
                .taxId(personRequest.getTaxId())
                .areaCode(personRequest.getAreaCode())
                .phoneNumber(personRequest.getPhoneNumber())
                .birthDate(personRequest.getBirthDate())
                .address(toAddressEntity(personRequest.getAddress()))
                .userAccounts(personRequest.getUserAccounts().stream()
                        .map(accountRequest -> AccountEntity.builder()
                                .numberAccount(accountRequest.getNumberAccount())
                                .totalBalance(accountRequest.getTotalBalance())
                                .userTransactions(accountRequest.getUserTransactions()
                                        .stream().map(transitionRequest -> TransitionEntity.builder()
                                                .date(transitionRequest.getDate())
                                                .value(transitionRequest.getValue())
                                                .description(transitionRequest.getDescription())
                                                .idAccount(transitionRequest.getIdAccount())
                                                .build()).collect(Collectors.toList()))
                                .idPerson(accountRequest.getIdPerson())
                                .build()).collect(Collectors.toList()))
                .build();
    }

    public AddressEntity toAddressEntity(AddressRequest addressRequest) {
        return AddressEntity.builder()
                .city(addressRequest.getCity())
                .country(addressRequest.getCountry())
                .number(addressRequest.getNumber())
                .postalCode(addressRequest.getPostalCode())
                .states(addressRequest.getStates())
                .street(addressRequest.getStreet())
                .build();
    }

    public PersonResponse toResponse(PersonEntity personEntity) {
        return PersonResponse.builder()
                .id(personEntity.getId())
                .name(personEntity.getName())
                .taxId(personEntity.getTaxId())
                .areaCode(personEntity.getAreaCode())
                .phoneNumber(personEntity.getPhoneNumber())
                .birthDate(personEntity.getBirthDate())
                .address(toAddressResponse(personEntity.getAddress()))
                .userAccounts(personEntity.getUserAccounts().stream()
                        .map(accountEntity -> AccountResponse.builder()
                                .id(accountEntity.getId())
                                .numberAccount(accountEntity.getNumberAccount())
                                .totalBalance(accountEntity.getTotalBalance())
                                .userTransactions(accountEntity.getUserTransactions()
                                        .stream().map(transitionEntity -> TransitionResponse.builder()
                                                .id(transitionEntity.getId())
                                                .date(transitionEntity.getDate())
                                                .value(transitionEntity.getValue())
                                                .description(transitionEntity.getDescription())
                                                .idAccount(transitionEntity.getIdAccount())
                                                .build()).collect(Collectors.toList()))
                                .idPerson(accountEntity.getIdPerson())
                                .build()).collect(Collectors.toList()))
                .build();
    }

    public AddressResponse toAddressResponse(AddressEntity addressEntity) {
        return AddressResponse.builder()
                .id(addressEntity.getId())
                .city(addressEntity.getCity())
                .country(addressEntity.getCountry())
                .number(addressEntity.getNumber())
                .postalCode(addressEntity.getPostalCode())
                .states(addressEntity.getStates())
                .street(addressEntity.getStreet())
                .idPerson(addressEntity.getIdPerson())
                .build();
    }

}
