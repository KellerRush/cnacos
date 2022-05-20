package com.kellerrush.cnacos.api;

import com.kellerrush.cnacos.api.config.ConfigFactory;
import com.kellerrush.cnacos.api.config.ConfigService;
import com.kellerrush.cnacos.api.naming.NamingFactory;
import com.kellerrush.cnacos.api.naming.NamingService;

public class CNacosFactory {

    public static NamingService createNamingService(String serverList){
        return NamingFactory.createNamingService(serverList);
    }

    public static ConfigService createConfigService(String serverList){
        return ConfigFactory.createConfigService(serverList);
    }

}
