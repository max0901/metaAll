package com.ohgiraffers.section03.properties.subsection02.il8n;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class ContextConfiguration {

    @Bean
    public ReloadableResourceBundleMessageSource messageSource(){
        ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource=
                new ReloadableResourceBundleMessageSource();
        reloadableResourceBundleMessageSource.setBasename("section03/properties/subsectuon01/value/subsection02/i18n/message");
reloadableResourceBundleMessageSource.setDefaultEncoding("UTF-8");
    return reloadableResourceBundleMessageSource;
    };

}
