package com.pichincha.evaluation.fdamsaevaluationtokengenerator.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.nimbusds.jose.JOSEException;
import com.pichincha.evaluation.fdamsaevaluationtokengenerator.exception.TokenGeneratorException;
import com.pichincha.evaluation.fdamsaevaluationtokengenerator.helper.TokenGenerator;
import com.pichincha.evaluation.fdamsaevaluationtokengenerator.service.dto.PostUserDataRequestDto;
import com.pichincha.evaluation.fdamsaevaluationtokengenerator.service.dto.PostUserDataResponseDto;
import com.pichincha.evaluation.fdamsaevaluationtokengenerator.service.mapper.TokenMapper;
import com.pichincha.evaluation.fdamsaevaluationtokengenerator.util.MockUtils;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {TokenGeneratorServiceImplTest.class})
class TokenGeneratorServiceImplTest {

  @Mock TokenGenerator tokenGenerator;
  @Mock TokenMapper tokenMapper;
  @InjectMocks TokenGeneratorServiceImpl tokenGeneratorService;

  @Test
  @DisplayName("Should return a valid token")
  void shouldReturnAValidResponse() throws Exception {
    PostUserDataRequestDto requestDto = MockUtils.REQUEST_DTO;

    when(tokenGenerator.generateJWT(any())).thenReturn(MockUtils.TOKEN_RESPONSE);
    when(tokenMapper.mapToPostUserDataResponseDto(any()))
        .thenReturn(MockUtils.POST_USER_DATA_RESPONSE_DTO);

    Optional<PostUserDataResponseDto> result = tokenGeneratorService.generateToken(requestDto);

    assertTrue(result.isPresent());
    assertNotNull(result.get());

    verify(tokenGenerator, times(1)).generateJWT(any());
    verify(tokenMapper, times(1)).mapToPostUserDataResponseDto(any());
  }

  @Test
  @DisplayName("Should throw a Exception")
  void givenANotValidKeyTokenGeneratorShouldThrowAnException() throws Exception {
    PostUserDataRequestDto requestDto = MockUtils.REQUEST_DTO;

    when(tokenGenerator.generateJWT(any())).thenThrow(JOSEException.class);

    assertThrows(
        TokenGeneratorException.class, () -> tokenGeneratorService.generateToken(requestDto));

    verify(tokenGenerator, times(1)).generateJWT(any());
    verify(tokenMapper, never()).mapToPostUserDataResponseDto(any());
  }
}
