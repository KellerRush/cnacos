package com.kellerrush.cnacos.common.notify;

import com.kellerrush.cnacos.common.notify.lifecycle.Closeable;
import com.kellerrush.cnacos.common.notify.listener.Subscriber;

public interface EventPublisher extends Closeable {

    void init(Class<?extends Event> type, int bufferSize);

    long currentEventSize();

    void addSubscriber(Subscriber subscriber);

    void removeSubscriber(Subscriber subscriber);

    boolean publish(Event event);

    void notifySubscriber(Subscriber subscriber, Event event);


    @Override
    default void shutdown() {

    }
}
