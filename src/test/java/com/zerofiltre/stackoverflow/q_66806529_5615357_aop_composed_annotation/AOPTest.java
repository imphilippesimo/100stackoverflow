package com.zerofiltre.stackoverflow.q_66806529_5615357_aop_composed_annotation;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
public class AOPTest {

  @Autowired
  Incrementor incrementor;


  @Test
  void aspectIsCalled() {
    assertThat(incrementor.incrementValue(2)).isEqualTo(2);
  }

}
