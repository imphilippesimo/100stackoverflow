package com.zerofiltre.stackoverflow.q_66537233_5615357_propertysource;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SecretTests {

  @Autowired
  private Secrets secrets;

  @Test
  public void secrets_shouldNotBeNull(){
    assertThat(secrets.getCredentialFileName()).isEqualTo("/my/file");
  }

}
