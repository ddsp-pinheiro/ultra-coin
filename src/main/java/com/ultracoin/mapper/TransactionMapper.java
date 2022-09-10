package com.ultracoin.mapper;

import com.ultracoin.entity.TransitionEntity;
import com.ultracoin.request.TransitionRequest;
import com.ultracoin.response.TransitionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {
    public TransitionEntity toEntity(TransitionRequest transitionRequest){
        return TransitionEntity.builder()
                .date(transitionRequest.getDate())
                .value(transitionRequest.getValue())
                .description(transitionRequest.getDescription())
                .build();
    }

    public TransitionResponse toResponse(TransitionEntity transitionEntity){
        return TransitionResponse.builder()
                .date(transitionEntity.getDate())
                .value(transitionEntity.getValue())
                .description(transitionEntity.getDescription())
                .idAccount(transitionEntity.getIdAccount())
                .id(transitionEntity.getId())
                .build();
    }
}
