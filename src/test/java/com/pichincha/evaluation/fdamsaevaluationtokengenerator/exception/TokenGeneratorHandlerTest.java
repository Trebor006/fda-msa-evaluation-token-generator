package com.pichincha.evaluation.fdamsaevaluationtokengenerator.exception;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pichincha.evaluation.fdamsaevaluationtokengenerator.service.TokenGeneratorService;
import com.pichincha.evaluation.fdamsaevaluationtokengenerator.util.MockUtils;
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
class TokenGeneratorHandlerTest {

  public static final String PATH = "/tokenizer/generate";
  @Autowired private MockMvc mockMvc;

  @MockBean private TokenGeneratorService tokenGeneratorService;

  @Test
  @DisplayName("POST /tokenizer/generate - Exception")
  void givenAValidDataShouldPostExceptionsAndCommentsProcess() throws Exception {

    when(tokenGeneratorService.generateToken(MockUtils.POST_USER_DATA_REQUEST_DTO))
        .thenThrow(TokenGeneratorException.class);

    mockMvc
        .perform(
            post(PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    new ObjectMapper().writeValueAsString(MockUtils.POST_USER_DATA_REQUEST_DTO)))
        .andExpect(status().is5xxServerError())
        .andReturn();

    verify(tokenGeneratorService, times(1)).generateToken(MockUtils.POST_USER_DATA_REQUEST_DTO);
  }
}
