package com.kellerrush.cloud.cnacos;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NacosDiscoveryClientAutoConfiguration {

    @Bean
    public NacosDiscoveryProperties nacosDiscoveryProperties(){
        return new NacosDiscoveryProperties();
    }

}
