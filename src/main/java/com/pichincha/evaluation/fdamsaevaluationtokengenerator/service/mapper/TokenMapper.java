package com.pichincha.evaluation.fdamsaevaluationtokengenerator.service.mapper;

import com.pichincha.evaluation.fdamsaevaluationtokengenerator.service.dto.PostUserDataResponseDto;
import lombok.Generated;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Generated
@Mapper(componentModel = "spring")
public interface TokenMapper {

  @Mapping(target = "token", source = "token")
  PostUserDataResponseDto mapToPostUserDataResponseDto(String token);
}
