package com.ultracoin.mapper;

import com.ultracoin.entity.TransitionEntity;
import com.ultracoin.request.TransitionRequest;
import com.ultracoin.response.TransitionResponse;
import org.springframework.stereotype.Component;

@Component
public class TransitionMapper {
    public TransitionEntity toEntity(TransitionRequest transitionRequest){
        return TransitionEntity.builder()
                .value(transitionRequest.getValue())
                .description(transitionRequest.getDescription())
                .type(transitionRequest.getType())
                .build();
    }

    public TransitionResponse toResponse(TransitionEntity transitionEntity){
        return TransitionResponse.builder()
                .date(transitionEntity.getDate())
                .type(transitionEntity.getType())
                .value(transitionEntity.getValue())
                .description(transitionEntity.getDescription())
                .idAccount(transitionEntity.getIdAccount())
                .id(transitionEntity.getId())
                .build();
    }
}
