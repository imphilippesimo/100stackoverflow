package com.zerofiltre.stackoverflow.q_66417284_5615357_zalando;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.problem.ProblemModule;
import org.zalando.problem.validation.ConstraintViolationProblemModule;

@Configuration
public class Configurations {

  @Bean
  public ObjectMapper objectMapper() {
    return new ObjectMapper().registerModules(
        new ProblemModule(),
        new ConstraintViolationProblemModule());
  }

}
