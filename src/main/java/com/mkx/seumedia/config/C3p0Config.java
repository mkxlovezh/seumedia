package com.mkx.seumedia.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
//@SpringBootConfiguration
public class C3p0Config{
//    @ConfigurationProperties(prefix = "c3p0.datasource")
//    @Primary
//    @Bean(name = "dataSource")
//    public DataSource c3p0datasource(){
//        return DataSourceBuilder.create().type(com.mchange.v2.c3p0.ComboPooledDataSource.class).build();
//    }
}
