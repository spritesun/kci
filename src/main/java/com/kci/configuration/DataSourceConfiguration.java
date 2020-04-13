package com.kci.configuration;

import org.dizitart.no2.Nitrite;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfiguration {
    @Bean
    Nitrite dataSource() {
        return Nitrite.builder()
                .compressed()
                .filePath("/tmp/kci-data.db")
                .openOrCreate("user", "password");

    }
}
