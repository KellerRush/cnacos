package com.kellerrush.cnacos.common.notify.listener;

import com.kellerrush.cnacos.common.notify.Event;

import java.util.List;

public abstract class SmartSubscriber extends Subscriber {
    public abstract List<Class<? extends Event>> subscribeTypes();

    @Override
    public Class<? extends Event> subscribeType() {
        return null;
    }

    @Override
    public boolean ignoreExpireEvent() {
        return false;
    }
}
