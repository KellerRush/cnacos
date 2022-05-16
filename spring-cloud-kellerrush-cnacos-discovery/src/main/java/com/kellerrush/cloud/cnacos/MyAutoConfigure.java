package com.kellerrush.cloud.cnacos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(MyProperties.class)
@Configuration
public class MyAutoConfigure {

    @Autowired
    private MyProperties myProperties;

    @Bean
    @ConditionalOnProperty(prefix = "plusroax.address",value = "enabled", havingValue = "true",matchIfMissing = true)
    MyTemplete myTemplete (){
        return new MyTemplete (myProperties);
    }

}
