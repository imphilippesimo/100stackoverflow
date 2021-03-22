package com.zerofiltre.stackoverflow.q_66681373_5615357_config_properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "aws-secretmanager")
@Data
@Configuration
public class MyInfoDataClass {

  private String secretName;
  private String region;

}
