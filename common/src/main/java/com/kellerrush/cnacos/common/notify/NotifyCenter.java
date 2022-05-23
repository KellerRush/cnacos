package com.kellerrush.cnacos.common.notify;

import com.kellerrush.cnacos.common.notify.listener.SmartSubscriber;
import com.kellerrush.cnacos.common.notify.listener.Subscriber;

public class NotifyCenter {



    public static void registerSubscriber(final Subscriber subscriber){

    }

    public static void registerSubscriber(final Subscriber consumer, EventPublisherFactory factory){
        if(consumer instanceof SmartSubscriber){
            for (Class<?extends Event> item: ((SmartSubscriber) consumer).subscribeTypes()){
                // 添加订阅事件
            }
        }

        Class<? extends Event> subscribeType = consumer.subscribeType();

        // 添加订阅事件

    }

    private static void addSubscriber(final Subscriber consumer,
                                      Class<? extends Event> subscribeType,
                                      EventPublisherFactory factory){


    }







}
