package com.kellerrush.cnacos.common.notify.notify.listener;

import com.kellerrush.cnacos.common.notify.notify.Event;

import java.util.concurrent.Executor;

public abstract class Subscriber<T extends Event> {

    public abstract void onEvent(T event);

    public abstract Class<? extends Event> subscribeType();

    public Executor executor(){return null;}

    public boolean isIgnoreExpireEvent(){
        return false;
    }


}
