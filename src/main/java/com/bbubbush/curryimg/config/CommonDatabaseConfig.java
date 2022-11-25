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
  basePackages = "com.bbubbush.curryimg.repository.common",
  entityManagerFactoryRef = "commonEntityManger",
  transactionManagerRef = "commonTransactionManager"
)
public class CommonDatabaseConfig {
  private final JpaProperties jpaProperties;
  private final HibernateProperties hibernateProperties;

  @Bean
  public LocalContainerEntityManagerFactoryBean commonEntityManger(EntityManagerFactoryBuilder builder) {
    final Map<String, Object> properties = hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());

    return builder.dataSource(commonDataSource())
      .packages("com.bbubbush.curryimg.entity.common")
      .persistenceUnit("commonTransactionManager")
      .properties(properties)
      .build();
  }

  @Bean
  @ConfigurationProperties(prefix="spring.common-datasource.hikari")
  public DataSource commonDataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean
  public PlatformTransactionManager commonTransactionManager(@Qualifier("commonEntityManger") EntityManagerFactory commonEntityManger) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(commonEntityManger);
    return transactionManager;
  }

}
