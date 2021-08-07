package com.customer.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@RefreshScope
@Configuration
public class JpaConfig {

    @Value("${application.db-username}")
    private String dbUserName;

    @Value("${application.db-password}")
    private String dbPassword;

    @Bean
    public DataSource getDataSource() {
        var dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.username(dbUserName);
        dataSourceBuilder.password(dbPassword);
        return dataSourceBuilder.build();
    }
}
