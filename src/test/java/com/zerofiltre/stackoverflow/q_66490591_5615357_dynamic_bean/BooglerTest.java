package com.zerofiltre.stackoverflow.q_66490591_5615357_dynamic_bean;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BooglerTest {

  @Autowired
  BoogleFeature boogleFeature;

  @Test
  void boogleFeature_ShouldBeInstantiated() {
    String result = boogleFeature.doBoogle("The boogler");

    assert "The boogler is boogling".equals(result);
  }

}
