package com.kellerrush.cnacos.common.notify;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

public abstract class Event implements Serializable {

    private static final long serialVersionUID = -4355188329533176889L;

    private AtomicLong SEQUENCE = new AtomicLong(0);

    private long sequence = SEQUENCE.getAndIncrement();

    public long sequence(){
        return sequence;
    }


}
