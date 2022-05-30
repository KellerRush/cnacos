package com.kellerrush.cnacos.common.notify;


import com.kellerrush.cnacos.common.notify.utils.ThreadUtils;
import org.junit.Test;

public class NotifyCenterTest {

    public class TestEvent1 extends Event{

    }

    @Test
    public void testMutipleKindsEventsCanListenBySmartsubscriber(){

        // 初始化注册者
        NotifyCenter.registerToPublisher(TestEvent1.class, 1000);
        ThreadUtils.sleep(3000L);
        NotifyCenter.publishEvent(new TestEvent1());
        ThreadUtils.sleep(3000L);
        NotifyCenter.publishEvent(new TestEvent1());
        ThreadUtils.sleep(3000L);
        NotifyCenter.publishEvent(new TestEvent1());
        ThreadUtils.sleep(30000L);
    }

    @Test
    public void testPublishEventByNoSubscriber(){

        NotifyCenter.publishEvent(new TestEvent1());

    }


}
