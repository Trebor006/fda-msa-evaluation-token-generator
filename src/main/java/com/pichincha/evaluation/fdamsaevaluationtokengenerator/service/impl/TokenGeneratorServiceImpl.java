package com.pichincha.evaluation.fdamsaevaluationtokengenerator.service.impl;

import com.nimbusds.jose.JOSEException;
import com.pichincha.evaluation.fdamsaevaluationtokengenerator.domain.enums.TokenErrors;
import com.pichincha.evaluation.fdamsaevaluationtokengenerator.exception.TokenGeneratorException;
import com.pichincha.evaluation.fdamsaevaluationtokengenerator.helper.TokenGenerator;
import com.pichincha.evaluation.fdamsaevaluationtokengenerator.service.TokenGeneratorService;
import com.pichincha.evaluation.fdamsaevaluationtokengenerator.service.dto.PostUserDataRequestDto;
import com.pichincha.evaluation.fdamsaevaluationtokengenerator.service.dto.PostUserDataResponseDto;
import com.pichincha.evaluation.fdamsaevaluationtokengenerator.service.mapper.TokenMapper;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenGeneratorServiceImpl implements TokenGeneratorService {

  private final TokenGenerator tokenGenerator;
  private final TokenMapper tokenMapper;

  @Override
  public Optional<PostUserDataResponseDto> generateToken(PostUserDataRequestDto requestDto) {

    try {
      PostUserDataResponseDto responseDto =
          tokenMapper.mapToPostUserDataResponseDto(
              tokenGenerator.generateJWT(requestDto.getUser()));

      return Optional.of(responseDto);

    } catch (JOSEException e) {
      throw new TokenGeneratorException(TokenErrors.TOKEN_GENERATE);
    }
  }
}
