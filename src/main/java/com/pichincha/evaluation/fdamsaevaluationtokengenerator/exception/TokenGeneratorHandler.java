package com.pichincha.evaluation.fdamsaevaluationtokengenerator.exception;

import com.pichincha.evaluation.fdamsaevaluationtokengenerator.service.dto.ErrorDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class TokenGeneratorHandler {

  @ExceptionHandler({TokenGeneratorException.class})
  public ResponseEntity<ErrorDto> handleException(TokenGeneratorException tokenGeneratorException) {
    log.error(tokenGeneratorException.getTitle() + " " + tokenGeneratorException.getDetail());

    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(
            ErrorDto.builder()
                .detail(tokenGeneratorException.getDetail())
                .title(tokenGeneratorException.getTitle())
                .type(tokenGeneratorException.getType())
                .instance(tokenGeneratorException.getInstance())
                .build());
  }
}
