package com.pichincha.evaluation.fdamsaevaluationtokengenerator.domain.enums;

import lombok.Getter;

@Getter
public enum TokenErrors {
  TOKEN_GENERATE(
      "Error generating the Token due to unexpected ",
      "Token Error",
      "TOB-001",
      "/tokenizer/generate");

  private final String detail;
  private final String title;
  private final String instance;
  private final String type;

  TokenErrors(String detail, String title, String instance, String type) {
    this.detail = detail;
    this.title = title;
    this.instance = instance;
    this.type = type;
  }
}
