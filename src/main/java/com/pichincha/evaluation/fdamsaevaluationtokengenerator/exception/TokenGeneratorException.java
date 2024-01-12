package com.pichincha.evaluation.fdamsaevaluationtokengenerator.exception;

import com.pichincha.evaluation.fdamsaevaluationtokengenerator.domain.enums.TokenErrors;
import lombok.Getter;

@Getter
public class TokenGeneratorException extends RuntimeException {

  final String detail;
  final String title;
  final String instance;
  final String type;

  public TokenGeneratorException(TokenErrors tokenError) {
    this.detail = tokenError.getDetail();
    this.title = tokenError.getTitle();
    this.instance = tokenError.getInstance();
    this.type = tokenError.getType();
  }
}
