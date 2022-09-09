package com.ultracoin.mapper;

import com.ultracoin.entity.AddressEntity;
import com.ultracoin.entity.PersonEntity;
import com.ultracoin.request.PersonRequest;
import com.ultracoin.response.PersonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonMapper {
    public final AddressMapper addressMapper;
//    public PersonEntity toEntityWithAccount(PersonRequest personRequest) {
//        return PersonEntity.builder()
//                .name(personRequest.getName())
//                .taxId(personRequest.getTaxId())
//                .areaCode(personRequest.getAreaCode())
//                .phoneNumber(personRequest.getPhoneNumber())
//                .birthDate(personRequest.getBirthDate())
//                .userAccounts(personRequest.getUserAccounts().stream()
//                        .map(accountRequest -> AccountEntity.builder()
//                                .numberAccount(accountRequest.getNumberAccount())
//                                .totalBalance(accountRequest.getTotalBalance())
//                                .userTransactions(accountRequest.getUserTransactions()
//                                        .stream().map(transitionRequest -> TransitionEntity.builder()
//                                                .date(transitionRequest.getDate())
//                                                .value(transitionRequest.getValue())
//                                                .description(transitionRequest.getDescription())
//                                                .idAccount(transitionRequest.getIdAccount())
//                                                .build()).collect(Collectors.toList()))
//                                .idPerson(accountRequest.getIdPerson())
//                                .build()).collect(Collectors.toList()))
//                .build();
//    }



    public PersonEntity toEntity(PersonRequest personRequest) {
        return PersonEntity.builder()
                .name(personRequest.getName())
                .taxId(personRequest.getTaxId())
                .areaCode(personRequest.getAreaCode())
                .phoneNumber(personRequest.getPhoneNumber())
                .birthDate(personRequest.getBirthDate())
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
                .address(addressMapper.toResponse(personEntity.getAddress()))
                .build();
    }
    public PersonResponse toResponse(PersonEntity personEntity,AddressEntity addressEntity) {
        return PersonResponse.builder()
                .id(personEntity.getId())
                .name(personEntity.getName())
                .taxId(personEntity.getTaxId())
                .areaCode(personEntity.getAreaCode())
                .phoneNumber(personEntity.getPhoneNumber())
                .birthDate(personEntity.getBirthDate())
                .build();
    }

//    public PersonResponse toResponseForGet(PersonEntity personEntity) {
//        return PersonResponse.builder()
//                .id(personEntity.getId())
//                .name(personEntity.getName())
//                .taxId(personEntity.getTaxId())
//                .areaCode(personEntity.getAreaCode())
//                .phoneNumber(personEntity.getPhoneNumber())
//                .birthDate(personEntity.getBirthDate())
//                .address(addressMapper.toResponse(personEntity.getAddress()))
//                .build();
//    }
//
//    public PersonResponse toResponseWithout(PersonEntity personEntity) {
//        return PersonResponse.builder()
//                .id(personEntity.getId())
//                .name(personEntity.getName())
//                .taxId(personEntity.getTaxId())
//                .areaCode(personEntity.getAreaCode())
//                .phoneNumber(personEntity.getPhoneNumber())
//                .birthDate(personEntity.getBirthDate())
//                .userAccounts(personEntity.getUserAccounts().stream()
//                        .map(accountEntity -> AccountResponse.builder()
//                                .id(accountEntity.getId())
//                                .numberAccount(accountEntity.getNumberAccount())
//                                .totalBalance(accountEntity.getTotalBalance())
//                                .userTransactions(accountEntity.getUserTransactions()
//                                        .stream().map(transitionEntity -> TransitionResponse.builder()
//                                                .id(transitionEntity.getId())
//                                                .date(transitionEntity.getDate())
//                                                .value(transitionEntity.getValue())
//                                                .description(transitionEntity.getDescription())
//                                                .idAccount(transitionEntity.getIdAccount())
//                                                .build()).collect(Collectors.toList()))
//                                .idPerson(accountEntity.getIdPerson())
//                                .build()).collect(Collectors.toList()))
//                .build();
//    }
}
