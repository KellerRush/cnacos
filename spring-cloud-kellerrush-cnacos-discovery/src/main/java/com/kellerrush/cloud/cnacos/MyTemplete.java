package com.kellerrush.cloud.cnacos;

public class MyTemplete {
    private String host;
    private int port;

    public MyTemplete (MyProperties myProperties){
        this.host = myProperties.getHost();
        this.port = myProperties.getPort();
    }

    public void print(){
        System.out.println(this.host + ":" +this.port);
    }
}
