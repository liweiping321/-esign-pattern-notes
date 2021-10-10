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
    public  long executeTime;
    /**
     * 序列
     */
    private final int sequence;
    /**
     * 任务执行结束时间
     */
    public final long taskEndTime;
    /**
     * 任务执行周期
     */
    public final long period;

    public DelayedTask(long executeTime, Runnable action) {
        this(executeTime, executeTime, 0, action);
    }

    public DelayedTask(long executeTime, long taskEndTime, long period, Runnable action) {
        this.executeTime = executeTime;
        this.taskEndTime = taskEndTime;
        this.period = period;
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
