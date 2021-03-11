package com.zerofiltre.stackoverflow.q_66537233_5615357_propertysource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("file:sheets.properties")
public class SheetsConfiguration {

  @Bean
  public Secrets clientSecrets(@Value("${sheets.credentials.file}") String credentialFileName) {
    return new Secrets(credentialFileName);

  }

  @Bean
  public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
    return new PropertySourcesPlaceholderConfigurer();
  }

}
