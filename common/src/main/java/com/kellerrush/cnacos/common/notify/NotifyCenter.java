package com.kellerrush.cnacos.common.notify;

import com.kellerrush.cnacos.common.notify.listener.SmartSubscriber;
import com.kellerrush.cnacos.common.notify.listener.Subscriber;
import com.kellerrush.cnacos.common.notify.utils.ClassUtils;
import com.kellerrush.cnacos.common.notify.utils.MapUtil;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NotifyCenter {

    private static NotifyCenter INSTANCE = new NotifyCenter();

    private final Map<String, EventPublisher> publisherMap = new ConcurrentHashMap<>(16);

    private static Class<? extends EventPublisher> clazz;

    private static EventPublisherFactory DEFAULT_PUBLISHER_FACTORY;

    static {
        clazz = DefaultPublisher.class;
        try {
            EventPublisher publisher = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        DEFAULT_PUBLISHER_FACTORY = (cls, buffer) -> {
            EventPublisher publisher = null;
            try {
                publisher = clazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            publisher.init(cls, buffer);
            return publisher;
        };

    }

    public static void shutdown(){
        for (Map.Entry<String, EventPublisher> entry : INSTANCE.publisherMap.entrySet()){
            EventPublisher eventPublisher = entry.getValue();
            eventPublisher.shutdown();
        }
    }


    public static boolean publishEvent(Event event) {
        return publishEvent(event.getClass(), event);
    }


    public static boolean publishEvent(Class<? extends Event> eventType, Event event) {

        String topic = ClassUtils.getCanonicalName(eventType);

        EventPublisher publisher = INSTANCE.publisherMap.get(topic);

        if (null != publisher) {
            return publisher.publish(event);
        }

        return false;
    }

    public static EventPublisher registerToPublisher(Class<? extends Event> eventType, int queueMaxSizey){
        String topic = ClassUtils.getCanonicalName(eventType);
        MapUtil.computeIfAbsent(INSTANCE.publisherMap, topic, DEFAULT_PUBLISHER_FACTORY , eventType, queueMaxSizey);

        return INSTANCE.publisherMap.get(topic);
    }


    public static EventPublisher registerToPublisher(Class<? extends Event> eventType, EventPublisherFactory eventPublisherFactory, int queueMaxSize){
        String topic = ClassUtils.getCanonicalName(eventType);
        MapUtil.computeIfAbsent(INSTANCE.publisherMap, topic, eventPublisherFactory, eventType, queueMaxSize);

        return INSTANCE.publisherMap.get(topic);
    }





}
