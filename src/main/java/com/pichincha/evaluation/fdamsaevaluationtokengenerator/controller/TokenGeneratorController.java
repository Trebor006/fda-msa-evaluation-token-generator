package com.pichincha.evaluation.fdamsaevaluationtokengenerator.controller;

import com.pichincha.evaluation.fdamsaevaluationtokengenerator.service.TokenGeneratorService;
import com.pichincha.evaluation.fdamsaevaluationtokengenerator.service.dto.PostUserDataRequestDto;
import com.pichincha.evaluation.fdamsaevaluationtokengenerator.service.dto.PostUserDataResponseDto;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("tokenizer")
public class TokenGeneratorController {

  private final TokenGeneratorService tokenGeneratorService;

  @PostMapping("generate")
  public ResponseEntity<PostUserDataResponseDto> generateToken(
      @RequestBody PostUserDataRequestDto requestDto) {

    Optional<PostUserDataResponseDto> response = tokenGeneratorService.generateToken(requestDto);

    return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
  }
}
