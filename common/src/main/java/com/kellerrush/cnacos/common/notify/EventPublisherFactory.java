package com.kellerrush.cnacos.common.notify;

import java.util.function.BiFunction;

public interface EventPublisherFactory extends BiFunction<Class<?extends Event>, Integer, EventPublisher> {

    @Override
    EventPublisher apply(Class<? extends Event> eventType, Integer maxQueueSize);

}
