package com.pichincha.evaluation.fdamsaevaluationtokengenerator;

import com.pichincha.evaluation.fdamsaevaluationtokengenerator.configuration.TokenConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
  TokenConfiguration.class,
})
public class FdaMsaEvaluationTokenGeneratorApplication {

  public static void main(String[] args) {
    SpringApplication.run(FdaMsaEvaluationTokenGeneratorApplication.class, args);
  }
}
