package com.liwp.battle.actuator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.PriorityBlockingQueue;

import static com.liwp.battle.actuator.BattleLoop.STEP_TIME;

public class TaskQueue implements IUpdate {
    private static final Logger LOGGER = LogManager.getLogger(TaskQueue.class);

    private final PriorityBlockingQueue<DelayedTask> delayTasks = new PriorityBlockingQueue<>();

    public void addTask(long executeTime, Runnable run) {
        delayTasks.add(new DelayedTask(executeTime, run));
    }

    public void addTask(long executeTime, long taskEndTime, long period, Runnable run) {
        if(period<STEP_TIME){
            throw new IllegalArgumentException("The period must be greater than one frame:"+STEP_TIME);
        }
        delayTasks.add(new DelayedTask(executeTime, taskEndTime, period, run));
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
            //添加下一个执行周期的任务
            if (delayedTask.taskEndTime > now && delayedTask.period > 0) {
                delayedTask.executeTime += delayedTask.period;
                delayTasks.add(delayedTask);
            }
            try {
                delayedTask.run();
            } catch (Throwable e) {
                LOGGER.error(e.getMessage(), e);
            }

        }
    }


}
