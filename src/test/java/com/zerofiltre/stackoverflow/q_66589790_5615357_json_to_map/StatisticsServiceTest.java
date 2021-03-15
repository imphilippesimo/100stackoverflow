package com.zerofiltre.stackoverflow.q_66589790_5615357_json_to_map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.IOException;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StatisticsServiceTest {

  @Autowired
  StatisticsService statisticsService;


  @Test
  void convertData_ShouldReturnANonEmtpyMap() throws IOException {
    Map<String, String> map = statisticsService.convertData();
    assertThat(map.containsKey("firstname")).isTrue();
    assertThat(map.get("firstname")).isEqualTo("philippe");
  }
}
