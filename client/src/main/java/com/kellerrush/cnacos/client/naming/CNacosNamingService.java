package com.kellerrush.cnacos.client.naming;

import com.kellerrush.cnacos.api.naming.NamingService;

public class CNacosNamingService implements NamingService {
    public CNacosNamingService(String serverList){
        System.out.println("初始化客户端-注册中心");
    }

    public void init(){

    }

    @Override
    public void register() {
        System.out.println("注册中心成功");
    }
}
