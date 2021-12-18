package com.ale.lingo.config;

import com.ale.lingo.service.WordFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationLingo {
    @Bean
    public FactoryBean serviceLocatorFactoryBean(){
        ServiceLocatorFactoryBean serviceLocatorFactoryBean = new ServiceLocatorFactoryBean();
        serviceLocatorFactoryBean.setServiceLocatorInterface(WordFactory.class);
        return serviceLocatorFactoryBean;
    }
}
