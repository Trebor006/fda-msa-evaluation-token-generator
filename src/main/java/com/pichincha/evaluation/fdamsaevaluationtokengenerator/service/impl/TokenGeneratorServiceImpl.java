package com.pichincha.evaluation.fdamsaevaluationtokengenerator.service.impl;

import com.pichincha.evaluation.fdamsaevaluationtokengenerator.service.TokenGeneratorService;
import com.pichincha.evaluation.fdamsaevaluationtokengenerator.service.dto.PostUserDataRequestDto;
import com.pichincha.evaluation.fdamsaevaluationtokengenerator.service.dto.PostUserDataResponseDto;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TokenGeneratorServiceImpl implements TokenGeneratorService {
  @Override
  public Optional<PostUserDataResponseDto> generateToken(PostUserDataRequestDto requestDto) {

    // todo generate token with JWT!!!!

    PostUserDataResponseDto responseDto =
        PostUserDataResponseDto.builder().token(UUID.randomUUID().toString()).build();

    // todo Use Exception!! and controller Advice!!!

    return Optional.of(responseDto);
  }
}
