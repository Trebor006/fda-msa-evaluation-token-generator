package com.pichincha.evaluation.fdamsaevaluationtokengenerator.service.dto;

import static lombok.AccessLevel.PRIVATE;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class PostUserDataRequestDto {
  String user;
  String password;
}
