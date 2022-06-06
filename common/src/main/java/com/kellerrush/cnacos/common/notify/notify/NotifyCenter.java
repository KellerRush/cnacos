package com.kellerrush.cnacos.common.notify.notify;

import com.kellerrush.cnacos.api.exception.runtime.CNacosRuntimeException;
import com.kellerrush.cnacos.common.notify.utils.ClassUtils;
import com.kellerrush.cnacos.common.notify.utils.MapUtil;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NotifyCenter {


    private static NotifyCenter INSTANCE = new NotifyCenter();

    private static PublisherFactory DEFAULT_PUBLISHER_FACTORY;

    private static Class<? extends Publisher> clazz;

    private final Map<String, Publisher> publisherMap = new ConcurrentHashMap<>(16);

    static {

        clazz = DefaultPublisher.class;

        DEFAULT_PUBLISHER_FACTORY = (cls, buffer) -> {
            Publisher publisher = null;
            try {
                publisher = clazz.newInstance();
                publisher.init();
            } catch (Exception e) {
                throw new CNacosRuntimeException(1111, e);
            }
            return publisher;
        };

    }


    public static Publisher registerToPublisher(Class<? extends Event> eventType, int queueMaxSize){
        return registerToPublisher(eventType, DEFAULT_PUBLISHER_FACTORY, queueMaxSize);
    }

    public static Publisher registerToPublisher(Class<? extends Event> eventType, PublisherFactory factory, int queueMaxSize){
        final String topic = ClassUtils.getCanonicalName(eventType);
        synchronized (NotifyCenter.class) {
            // MapUtils.computeIfAbsent is a unsafe method.
            MapUtil.computeIfAbsent(INSTANCE.publisherMap, topic, factory, eventType, queueMaxSize);

            Publisher publisher = INSTANCE.publisherMap.computeIfAbsent(topic, (cls) -> {
                return new DefaultPublisher();
            });
            if(null == publisher){
                publisher = factory.apply(eventType, queueMaxSize);
            }
        }

        Publisher publisher =  INSTANCE.publisherMap.get(topic);
        return publisher;
    }

    public static boolean publishEvent(Event event){
        return publishEvent(event.getClass(), event);
    }

    private static boolean publishEvent(Class<? extends Event> eventType, final Event event) {
        final String topic = ClassUtils.getCanonicalName(eventType);
        Publisher publisher =  INSTANCE.publisherMap.get(topic);
        return publisher.publish(event);
    }


}
