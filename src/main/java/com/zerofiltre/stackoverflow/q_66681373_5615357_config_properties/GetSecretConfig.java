package com.zerofiltre.stackoverflow.q_66681373_5615357_config_properties;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetSecretConfig {

  @Bean
  public SecretDataClass getSecrets(MyInfoDataClass infoDataClass) {
    return new SecretDataClass(infoDataClass.getSecretName(), infoDataClass.getRegion());
  }
}
