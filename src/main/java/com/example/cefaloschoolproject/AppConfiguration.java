package com.example.cefaloschoolproject;

import org.apache.commons.cli.Options;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfiguration {
    @Bean
    @Scope("singleton")
    public CommandLineOptions options(){
        return new CommandLineOptions();
    }
    @Bean
    @Scope("singleton")
    public IDictionary dictionary(){
        return new TrieDictionary();
    }
}
