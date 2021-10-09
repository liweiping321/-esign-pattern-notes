package com.liwp.battle.actuator;

import java.util.concurrent.atomic.AtomicInteger;

public class DelayedTask implements Runnable, Comparable<DelayedTask> {
    private final static AtomicInteger SEQUENCE = new AtomicInteger();
    /**
     * 执行run
     */
    private final Runnable action;
    /**
     * 执行时间
     */
    public final long executeTime;
    /**
     * 序列
     */
    private final int sequence;

    public DelayedTask(long executeTime, Runnable action) {
        this.executeTime = executeTime;
        this.sequence = SEQUENCE.incrementAndGet();
        this.action = action;
    }

    @Override
    public int compareTo(DelayedTask o) {
        long diff = executeTime - o.executeTime;
        if (diff < 0) {
            return -1;
        } else if (diff > 0) {
            return 1;
        } else if (sequence < o.sequence) {
            return -1;
        } else if (sequence > o.sequence) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public void run() {
        action.run();
    }
}
