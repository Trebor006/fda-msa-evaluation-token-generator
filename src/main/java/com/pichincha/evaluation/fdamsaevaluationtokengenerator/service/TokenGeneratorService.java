package com.pichincha.evaluation.fdamsaevaluationtokengenerator.service;

import com.pichincha.evaluation.fdamsaevaluationtokengenerator.service.dto.PostUserDataRequestDto;
import com.pichincha.evaluation.fdamsaevaluationtokengenerator.service.dto.PostUserDataResponseDto;
import java.util.Optional;

public interface TokenGeneratorService {
  Optional<PostUserDataResponseDto> generateToken(PostUserDataRequestDto requestDto);
}
