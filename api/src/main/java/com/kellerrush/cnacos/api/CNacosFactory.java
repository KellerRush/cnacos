package com.kellerrush.cnacos.api;

import com.kellerrush.cnacos.api.config.ConfigService;
import com.kellerrush.cnacos.api.naming.NamingService;

public class CNacosFactory {

    public static NamingService createNamingService(String serverList){
        System.out.println("创建注册中心");
        return null;
    }

    public static ConfigService createConfigService(String serverList){
        System.out.println("创建配置中心");
        return null;
    }

}
