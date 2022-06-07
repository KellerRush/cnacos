package com.kellerrush.cnacos.common.notify.notify;

import com.kellerrush.cnacos.common.notify.notify.listener.Subscriber;
import com.kellerrush.cnacos.common.notify.utils.ConcurrentHashSet;
import com.kellerrush.cnacos.common.notify.utils.ThreadUtils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultPublisher extends Thread implements Publisher {


    private BlockingQueue<Event> queue;

    private ConcurrentHashSet<Subscriber> subscribers = new ConcurrentHashSet<>();

    private AtomicInteger recvCount = new AtomicInteger(0);


    @Override
    public void init() {
        System.out.println("init");
        this.queue = new ArrayBlockingQueue<>(1024);
        this.subscribers = new ConcurrentHashSet<>();
        start();
    }


    @Override
    public synchronized void start() {
        super.start();
    }

    @Override
    public void run() {
        super.run();
        while (true){
            try {
                Event event = queue.take();

//                System.out.println("收到一个事件" + queue.size());

                receiveEvent(event);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private void receiveEvent(Event event){
        recvCount.incrementAndGet();
//        System.out.println("处理接收事件，"+  recvCount.intValue());
        for (Subscriber subscriber: this.subscribers){
            notifySubscriber(subscriber, event);
        }
    }


    @Override
    public boolean publish(Event event) {
//        System.out.println("publish event");
        recvCount.incrementAndGet();
        return this.queue.offer(event);
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        this.subscribers.add(subscriber);
        System.out.println("addSubscribe");
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        this.subscribers.remove(subscriber);
        System.out.println("removeSubscribe");
    }

    @Override
    public void notifySubscriber(Subscriber subscriber, Event event) {
//        System.out.println("notifySubscriber");

        Runnable job = () -> subscriber.onEvent(event);
        Executor executor = subscriber.executor();
        if(executor != null){
            executor.execute(job);
        }else{
            try {
                job.run();
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }


}
