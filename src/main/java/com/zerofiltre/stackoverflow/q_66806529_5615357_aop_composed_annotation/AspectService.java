package com.zerofiltre.stackoverflow.q_66806529_5615357_aop_composed_annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Aspect
@Slf4j
@Service
public class AspectService {


  @Before("annotationsOfTypeTest()")
  public void aroundTestAnnotation() {
    log.info("==========aroundTestAnnotation executed====================");
  }

  @Pointcut("@target(com.zerofiltre.stackoverflow.q_66806529_5615357_aop_composed_annotation.TestAnnotation)")
  private void annotationsOfTypeTest() {

  }

}
