package com.kellerrush.cnacos.api.config;

import java.lang.reflect.Constructor;
import java.util.Properties;

public class ConfigFactory {
    public static ConfigService createConfigService(String serverAddr) {
        ConfigService vendorImpl = null;
        try {
            Class<?> driverImplClass = Class.forName("com.kellerrush.cnacos.client.naming.CNacosNamingService");
            Constructor constructor = driverImplClass.getConstructor(String.class);
            vendorImpl = (ConfigService) constructor.newInstance("123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vendorImpl;
    }
}
