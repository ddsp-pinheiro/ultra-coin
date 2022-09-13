package com.ultracoin.controller;

import com.ultracoin.entity.TransitionEntity;
import com.ultracoin.mapper.TransitionMapper;
import com.ultracoin.request.TransitionRequest;
import com.ultracoin.response.TransitionResponse;
import com.ultracoin.service.TransitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransitionController {

    private final TransitionService transitionService;
    private final TransitionMapper transitionMapper;
    private static final String ID_ACCOUNT = "x-id-account";

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransitionResponse postNewAccount(@Valid @RequestBody TransitionRequest transitionRequest, @RequestHeader(ID_ACCOUNT) Long id){
        TransitionEntity entity = transitionService.addNewTransition(transitionMapper.toEntity(transitionRequest), id);
        return transitionMapper.toResponse(entity);
    }
}
