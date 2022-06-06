package com.kellerrush.cnacos.common.notify.notify;

import java.util.function.BiFunction;

public interface PublisherFactory extends BiFunction<Class<? extends Event>, Integer, Publisher> {

    @Override
    Publisher apply(Class<? extends Event> event, Integer maxQueueSize);
}
