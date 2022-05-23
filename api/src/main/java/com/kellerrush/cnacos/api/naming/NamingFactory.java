package com.kellerrush.cnacos.api.naming;

import com.kellerrush.cnacos.api.config.ConfigService;

import java.lang.reflect.Constructor;
import java.util.Properties;

public class NamingFactory {
    public static NamingService createNamingService(String serverAddr) {
        NamingService vendorImpl = null;
        try {
            Class<?> driverImplClass = Class.forName("com.kellerrush.cnacos.client.naming.CNacosNamingService");
            Constructor constructor = driverImplClass.getConstructor(String.class);
            vendorImpl = (NamingService) constructor.newInstance("123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vendorImpl;
    }
}
