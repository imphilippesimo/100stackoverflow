package com.zerofiltre.stackoverflow.q_66554322_5615357_resource_value;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PathHolder {

  public static String prop;

  @Value("${input.file}")
  public void setProp(String prop) {
    PathHolder.prop = prop;
  }

}
