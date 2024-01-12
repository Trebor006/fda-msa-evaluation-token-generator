package com.pichincha.evaluation.fdamsaevaluationtokengenerator.util;

import com.pichincha.evaluation.fdamsaevaluationtokengenerator.service.dto.PostUserDataRequestDto;
import com.pichincha.evaluation.fdamsaevaluationtokengenerator.service.dto.PostUserDataResponseDto;

public class MockUtils {

  public static final PostUserDataRequestDto REQUEST_DTO = PostUserDataRequestDto.builder().build();
  public static final String TOKEN_RESPONSE =
      "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIiLCJleHAiOjE3MDUwNzIzNjUsImlhdCI6MTcwNTA3MjM1NX0.N1BXsEiJosyo_4dtQmYOtPJxC8uuWELKk1Cnb5UXZNw";
  public static final PostUserDataResponseDto POST_USER_DATA_RESPONSE_DTO =
      PostUserDataResponseDto.builder().token(TOKEN_RESPONSE).build();
  public static final PostUserDataRequestDto POST_USER_DATA_REQUEST_DTO =
      PostUserDataRequestDto.builder().user("").password("").build();
  ;

  private MockUtils() {}
}
