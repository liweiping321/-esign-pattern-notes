package com.liwp.battle.actuator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.PriorityBlockingQueue;

public class DelayedQueue implements IUpdate {
    private static final Logger LOGGER = LogManager.getLogger(DelayedQueue.class);

    private final PriorityBlockingQueue<DelayedTask> delayTasks = new PriorityBlockingQueue<>();

    public void addTask(long executeTime, Runnable run) {
        delayTasks.add(new DelayedTask(executeTime, run));
    }

    @Override
    public void update(long now) {
        for (; ; ) {
            DelayedTask delayedTask = delayTasks.poll();
            if (delayedTask == null) {
                return;
            }
            if (delayedTask.executeTime > now) {
                delayTasks.add(delayedTask);
                return;
            }
            try {
                delayedTask.run();
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
    }


}
