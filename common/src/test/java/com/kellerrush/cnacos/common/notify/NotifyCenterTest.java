package com.kellerrush.cnacos.common.notify;


import com.kellerrush.cnacos.common.notify.notify.Event;
import com.kellerrush.cnacos.common.notify.notify.NotifyCenter;
import com.kellerrush.cnacos.common.notify.notify.listener.Subscriber;
import com.kellerrush.cnacos.common.notify.utils.ThreadUtils;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class NotifyCenterTest {

    public class TestEvent1 extends Event {

    }

    @Test
    public void testMutipleKindsEventsCanListenBySmartsubscriber() {

//        // 初始化注册者
        NotifyCenter.registerToPublisher(TestEvent1.class, 1000);

        AtomicInteger sendCount = new AtomicInteger(0);
        NotifyCenter.registerSubscriber(new Subscriber() {
            AtomicInteger recvCount = new AtomicInteger(0);

            @Override
            public void onEvent(Event event) {
                System.out.println(recvCount);
                recvCount.incrementAndGet();
            }

            @Override
            public Class<? extends Event> subscribeType() {
                return TestEvent1.class;
            }
        });

        while (true) {
            NotifyCenter.publishEvent(new TestEvent1());
            sendCount.incrementAndGet();
            if (sendCount.intValue() >= 1000) {
                System.out.println("发送完毕" + sendCount.intValue());
                break;
            }
        }

        ThreadUtils.sleep(30000L);

    }

    @Test
    public void testPublishEventByNoSubscriber() {

//        NotifyCenter.publishEvent(new TestEvent1());

    }


}
