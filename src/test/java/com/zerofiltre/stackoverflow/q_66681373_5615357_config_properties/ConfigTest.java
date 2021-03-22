package com.zerofiltre.stackoverflow.q_66681373_5615357_config_properties;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConfigTest {

  @Autowired
  private SecretDataClass secretDataClass;

  @Test
  void data_ArePresent() {
    assertThat(secretDataClass.getRegion()).isEqualTo("us-west-2");
  }
}
