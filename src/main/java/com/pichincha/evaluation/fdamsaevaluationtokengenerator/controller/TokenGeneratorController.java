package com.pichincha.evaluation.fdamsaevaluationtokengenerator.controller;

import com.pichincha.evaluation.fdamsaevaluationtokengenerator.service.TokenGeneratorService;
import com.pichincha.evaluation.fdamsaevaluationtokengenerator.service.dto.PostUserDataRequestDto;
import com.pichincha.evaluation.fdamsaevaluationtokengenerator.service.dto.PostUserDataResponseDto;
//import com.pichincha.evaluation.fdamsaevaluationtokengenerator.service.validation.TokenGeneratorValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("tokenizer")
public class TokenGeneratorController {

  private final TokenGeneratorService tokenGeneratorService;
//  private final TokenGeneratorValidator tokenGeneratorValidator;

  @PostMapping("generate")
  public ResponseEntity<PostUserDataResponseDto> generateToken(
      @RequestBody PostUserDataRequestDto requestDto) {

    Optional<PostUserDataResponseDto> response = tokenGeneratorService.generateToken(requestDto);

    return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
  }

//  @InitBinder
//  protected void initBinder(WebDataBinder binder) {
//    Optional.ofNullable(binder.getTarget())
//        .ifPresent(
//            target -> {
//              if (tokenGeneratorValidator.supports(target.getClass())) {
//                binder.addValidators(tokenGeneratorValidator);
//              }
//            });
//  }
}
