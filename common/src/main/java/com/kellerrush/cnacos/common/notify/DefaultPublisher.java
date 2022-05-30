package com.kellerrush.cnacos.common.notify;

import com.kellerrush.cnacos.common.notify.listener.Subscriber;
import com.kellerrush.cnacos.common.notify.utils.ThreadUtils;
import com.sun.org.apache.bcel.internal.generic.RET;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class DefaultPublisher extends Thread implements EventPublisher {


    private BlockingQueue<Event> queue;


    @Override
    public void init(Class<? extends Event> type, int bufferSize) {

        System.out.println("CNacos.publisher-" + type.getName());
        this.queue = new ArrayBlockingQueue(bufferSize);
        start();
    }

    @Override
    public long currentEventSize() {
        return 0;
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {

    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {

    }

    @Override
    public boolean publish(Event event) {
        this.queue.offer(event);
        return true;
    }

    @Override
    public void notifySubscriber(Subscriber subscriber, Event event) {

    }

    @Override
    public void run() {
        //super.run();
        System.out.println("run.........");


        while (true){

            try {
                Event event = queue.take();
                // 这里处理事件
                System.out.println(event.getClass().getName());

                // 不断的从队列中读取数据，分发给订阅者


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ThreadUtils.sleep(1000L);


        }


    }

    @Override
    public synchronized void start() {
        super.start();
    }

    @Override
    public void shutdown() {
        System.out.println("shutdown....");
        this.queue.clear();
    }

}
