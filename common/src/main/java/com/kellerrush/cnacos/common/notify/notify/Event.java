package com.kellerrush.cnacos.common.notify.notify;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

public abstract class Event implements Serializable {
    private static final long serialVersionUID = 3713292167175656700L;

    private static AtomicLong SEQUENCE = new AtomicLong(0);

    private static long sequence = SEQUENCE.getAndIncrement();

    public static long getSequence() {
        return sequence;
    }
}
