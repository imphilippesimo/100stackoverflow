package com.zerofiltre.stackoverflow.q_66490591_5615357_dynamic_bean;

public class BoogleFeature {

  private String sdk;

  public BoogleFeature(String sdk) {
    this.sdk = sdk;
  }

  public String doBoogle() {
    return "Boogling with " + sdk;
  }
}
