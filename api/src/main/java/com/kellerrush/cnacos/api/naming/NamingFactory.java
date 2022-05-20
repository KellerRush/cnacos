package com.kellerrush.cnacos.api.naming;

import com.kellerrush.cnacos.api.config.ConfigService;

import java.lang.reflect.Constructor;
import java.util.Properties;

public class NamingFactory {
    public static NamingService createNamingService(String serverAddr) {
        NamingService vendorImpl = null;
        try {
            Class<?> driverImplClass = Class.forName("com.kellerrush.cnacos.client.config.CNacosNamingService");
            Constructor constructor = driverImplClass.getConstructor(Properties.class);
            vendorImpl = (NamingService) constructor.newInstance("123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vendorImpl;
    }
}
