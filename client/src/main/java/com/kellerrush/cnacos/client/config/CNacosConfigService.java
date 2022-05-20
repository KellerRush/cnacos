package com.kellerrush.cnacos.client.config;

import com.kellerrush.cnacos.api.config.ConfigService;

public class CNacosConfigService implements ConfigService {

    public CNacosConfigService(String serverList){
        System.out.println("初始化客户端-配置中心");
    }

    @Override
    public void register() {
        System.out.println("配置中心成功");
    }
}
