package com.pichincha.evaluation.fdamsaevaluationtokengenerator.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pichincha.evaluation.fdamsaevaluationtokengenerator.service.TokenGeneratorService;
import com.pichincha.evaluation.fdamsaevaluationtokengenerator.util.MockUtils;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class TokenGeneratorControllerTest {

  public static final String PATH = "/tokenizer/generate";
  @Autowired private MockMvc mockMvc;

  @MockBean private TokenGeneratorService tokenGeneratorService;

  @Test
  @DisplayName("POST /tokenizer/generate - Success")
  void givenAValidDataShouldGenerateAToken() throws Exception {

    when(tokenGeneratorService.generateToken(MockUtils.POST_USER_DATA_REQUEST_DTO))
            .thenReturn(Optional.of(MockUtils.POST_USER_DATA_RESPONSE_DTO));

    mockMvc
        .perform(
            post(PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    new ObjectMapper().writeValueAsString(MockUtils.POST_USER_DATA_REQUEST_DTO)))
        .andExpect(status().isOk())
        .andReturn();

    verify(tokenGeneratorService, times(1)).generateToken(MockUtils.POST_USER_DATA_REQUEST_DTO);
  }
}
