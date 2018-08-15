package com.target.interview.poc.commentmoderator.config;

import com.target.interview.poc.commentmoderator.constants.AppConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.embedded.*;

import javax.sql.DataSource;
import java.sql.Driver;

@Configuration
public class DevAppConfig {

    @Bean
    @Profile(AppConstants.DEV)
    public DataSource dataSource(){

        EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase embeddedDatabase = embeddedDatabaseBuilder
                .generateUniqueName(false)
                .setName(AppConstants.IN_MEMORY_SCHEMA_NAME)
                .setType(EmbeddedDatabaseType.HSQL)
                .setScriptEncoding(AppConstants.FILE_FORMAT_DEFAULT)
                .ignoreFailedDrops(true)
                .addScript(AppConstants.IN_MEMORY_SCHEMA_FILE)
                .addScripts(AppConstants.IN_MEMORY_INSERT_SCRIPT_FILE)
                .build();

        return embeddedDatabase;
    }
}
