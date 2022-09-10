package com.ultracoin.mapper;

import com.ultracoin.entity.PersonEntity;
import com.ultracoin.request.PersonRequest;
import com.ultracoin.response.AccountResponse;
import com.ultracoin.response.PersonResponse;
import com.ultracoin.response.TransitionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PersonMapper {
    public final AddressMapper addressMapper;
    public final AccountMapper accountMapper;

    public PersonEntity toEntity(PersonRequest personRequest) {
        return PersonEntity.builder()
                .name(personRequest.getName())
                .taxId(personRequest.getTaxId())
                .areaCode(personRequest.getAreaCode())
                .phoneNumber(personRequest.getPhoneNumber())
                .birthDate(personRequest.getBirthDate())
                .build();
    }
    public PersonResponse toResponseToPost(PersonEntity personEntity) {
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

    public PersonResponse toResponse(PersonEntity personEntity) {
        return PersonResponse.builder()
                .id(personEntity.getId())
                .name(personEntity.getName())
                .taxId(personEntity.getTaxId())
                .areaCode(personEntity.getAreaCode())
                .phoneNumber(personEntity.getPhoneNumber())
                .birthDate(personEntity.getBirthDate())
                .address(addressMapper.toResponse(personEntity.getAddress()))
                .userAccounts(personEntity.getUserAccounts()
                        .stream().map(accountEntity -> AccountResponse.builder()
                                .idPerson(accountEntity.getIdPerson())
                                .totalBalance(accountEntity.getTotalBalance())
                                .accountType(accountEntity.getAccountType())
                                .id(accountEntity.getId())
                                .accountNumber(accountEntity.getAccountNumber())
                                .userTransactions(accountEntity.getUserTransactions()
                                        .stream().map(transitionEntity -> TransitionResponse.builder()
                                                .id(transitionEntity.getId())
                                                .date(transitionEntity.getDate())
                                                .description(transitionEntity.getDescription())
                                                .value(transitionEntity.getValue())
                                                .idAccount(transitionEntity.getIdAccount())
                                                .build()).collect(Collectors.toList()))
                                .build()).collect(Collectors.toList()))
                .build();
    }
}
