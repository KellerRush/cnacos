package com.kellerrush.cnacos.common.notify.notify;

import com.kellerrush.cnacos.common.notify.notify.listener.Subscriber;

public interface Publisher {


    /**
     * 初始化事件
     */
    void init();

    /**
     * 发布事件
     */
    boolean publish(Event event);

    /**
     * 添加订阅
     */
    void addSubscriber(Subscriber subscriber);

    /**
     * 移除订阅
     */
    void removeSubscriber(Subscriber subscriber);


    /**
     * 通知消息
     */
    void notifySubscriber(Subscriber subscriber, Event event);


}
