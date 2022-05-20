package com.kellerrush.cnacos.api.config;

import java.lang.reflect.Constructor;
import java.util.Properties;

public class ConfigFactory {
    public static ConfigService createConfigService(String serverAddr) {
        ConfigService vendorImpl = null;
        try {
            Class<?> driverImplClass = Class.forName("com.kellerrush.cnacos.client.config.CNacosConfigService");
            Constructor constructor = driverImplClass.getConstructor(Properties.class);
            vendorImpl = (ConfigService) constructor.newInstance("123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vendorImpl;
    }
}
