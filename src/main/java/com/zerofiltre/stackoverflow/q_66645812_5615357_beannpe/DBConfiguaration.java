package com.zerofiltre.stackoverflow.q_66645812_5615357_beannpe;

import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.SharedEntityManagerCreator;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DBConfiguaration {

  @ConfigurationProperties(prefix = "spring.datasource.employees")
  @Bean
  public DataSource myDataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean myEntityManagerFactory() {
    LocalContainerEntityManagerFactoryBean employees = createEntityManagerFactory(
        myDataSource(), "Employees", new String[]{});
    return employees;
  }

  @Bean
  public EntityManager myEntityManager(@Qualifier("myEntityManagerFactory")
      EntityManagerFactory emf) {
    return entityManager(emf);
  }

  @Bean
  public JpaTransactionManager myTransactionManager(@Qualifier("myEntityManagerFactory")
      EntityManagerFactory emf) {
    return transactionManager(emf);
  }

  // Common methods
  private LocalContainerEntityManagerFactoryBean createEntityManagerFactory(
      DataSource dataSource, String persistenceUnitName, String[] mappings) {
    MyLocalContainerEntityManagerFactoryBean entityManagerFactory
        = new MyLocalContainerEntityManagerFactoryBean();
    entityManagerFactory.setDataSource(dataSource);
    entityManagerFactory.setPersistenceUnitName(persistenceUnitName);
    entityManagerFactory.setPackagesToScan("com.zerofiltre.100stackoverflow");
    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
    entityManagerFactory.setJpaProperties(additionalProperties());

    if (mappings != null) {
      entityManagerFactory.setMappingResources(mappings);
    }
    return entityManagerFactory;
  }

  private JpaTransactionManager transactionManager(EntityManagerFactory emf) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(emf);
    return transactionManager;
  }

  private EntityManager entityManager(EntityManagerFactory emf) {
    return SharedEntityManagerCreator.createSharedEntityManager(emf);
  }

  @Bean
  @Primary
  public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
    return new PersistenceExceptionTranslationPostProcessor();
  }

  private Properties additionalProperties() {
    Properties properties = new Properties();
    properties.setProperty("hibernate.hbm2ddl.auto", "none");
    //        properties.setProperty("hibernate.show_sql", "true");
    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLInnoDBDialect");
    return properties;
  }


}
