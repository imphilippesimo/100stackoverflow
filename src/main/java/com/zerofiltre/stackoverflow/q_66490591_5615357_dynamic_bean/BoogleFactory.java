package com.zerofiltre.stackoverflow.q_66490591_5615357_dynamic_bean;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BoogleFactory {

  @Autowired
  private GenericApplicationContext context;

  @PostConstruct
  public void createBoggleClient() {
    //build the sdk
    String sdk = "Boogle SDK";

    //then register the bean in spring context
    context.registerBean(BoogleFeature.class,sdk);
  }

}
