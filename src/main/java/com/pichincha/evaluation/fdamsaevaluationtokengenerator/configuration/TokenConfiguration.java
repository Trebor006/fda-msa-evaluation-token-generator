package com.pichincha.evaluation.fdamsaevaluationtokengenerator.configuration;

import static lombok.AccessLevel.PRIVATE;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@FieldDefaults(level = PRIVATE)
@Configuration
@ConfigurationProperties(prefix = "security")
public class TokenConfiguration {

  String secretKey;
  Long expirationMilis;
}
