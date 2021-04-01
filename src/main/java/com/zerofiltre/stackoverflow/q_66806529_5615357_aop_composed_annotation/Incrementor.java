package com.zerofiltre.stackoverflow.q_66806529_5615357_aop_composed_annotation;

import org.springframework.stereotype.Service;

@Service
public class Incrementor {

  @ComposedTestAnnotation
  int incrementValue(int value) {
    return value;
  }

}
