package com.bbubbush.curryimg.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
@EnableJpaRepositories(
  basePackages = "com.bbubbush.curryimg.repository.app",
  entityManagerFactoryRef = "serviceEntityManger",
  transactionManagerRef = "serviceTransactionManager"
)
public class ServiceDatabaseConfig {
  private final JpaProperties jpaProperties;
  private final HibernateProperties hibernateProperties;

  @Bean
  @Primary
  public LocalContainerEntityManagerFactoryBean serviceEntityManger(EntityManagerFactoryBuilder builder) {
    final Map<String, Object> properties = hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());

    return builder.dataSource(serviceDataSource())
      .packages("com.bbubbush.curryimg.entity.app")
      .persistenceUnit("serviceTransactionManager")
      .properties(properties)
      .build();
  }

  @Bean
  @Primary
  @ConfigurationProperties(prefix="spring.service-datasource.hikari")
  public DataSource serviceDataSource() {
    return DataSourceBuilder
      .create()
      .build();
  }

  @Bean
  @Primary
  public PlatformTransactionManager serviceTransactionManager(@Qualifier("serviceEntityManger") EntityManagerFactory serviceEntityManger) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(serviceEntityManger);
    return transactionManager;
  }
}
