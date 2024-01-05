//package com.pichincha.evaluation.fdamsaevaluationtokengenerator.service.validation;
//
//import com.pichincha.evaluation.fdamsaevaluationtokengenerator.service.dto.PostUserDataRequestDto;
//import java.util.Optional;
//import lombok.AccessLevel;
//import lombok.AllArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.lang.NonNull;
//import org.springframework.lang.Nullable;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//import org.springframework.validation.Validator;
//
//@Slf4j
//@Component
//@AllArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE)
//public class TokenGeneratorValidator implements Validator {
//  @Override
//  public boolean supports(@NonNull Class<?> clazz) {
//    return PostUserDataRequestDto.class.equals(clazz);
//  }
//
//  @Override
//  @NonNull
//  public void validate(@Nullable Object target, @NonNull Errors errors) {
//    Optional.ofNullable(target)
//        .filter(PostUserDataRequestDto.class::isInstance)
//        .map(PostUserDataRequestDto.class::cast)
//        .ifPresent(
//            request -> {
//
//                if (request.getUser().isBlank())
//                {
//                throw new IllegalArgumentException("The supplied [Validator] is " +
//                        "required and must not be null.");
//
//                }
//
//
////              ValidationUtils.rejectIfEmptyOrWhitespace(
////                  errors, "user", "token.generator.user.NotNull");
////              ValidationUtils.rejectIfEmptyOrWhitespace(
////                  errors, "password", "token.generator.password.NotNull");
//            });
//  }
//}
