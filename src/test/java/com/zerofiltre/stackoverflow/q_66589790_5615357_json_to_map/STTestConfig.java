package com.zerofiltre.stackoverflow.q_66589790_5615357_json_to_map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class STTestConfig {

  @Bean
  StatisticsService statisticsService(){
    return new StatisticsService();
  }

}
