package com.liwp.battle.actuator;

import com.liwp.battle.BaseBattle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

public class BattleLoop implements Runnable {

    private static final Logger LOGGER = LogManager.getLogger(BattleLoopGroup.class);

    public static final long STEP_TIME = 42;

    private static final long LOOP_TIME_OUT = 5000l;

    private Map<Integer, BaseBattle> battleMap = new ConcurrentSkipListMap<>();

    private LoopThread worker;

    private long lastExecuteTime;

    private volatile int threadId;

    private final int loopId;

    public BattleLoop(int loopId) {
        this.loopId = loopId;
        lastExecuteTime = System.currentTimeMillis();
        reStart();
    }

    private void reStart() {
        worker = new LoopThread(this, "loop_" + loopId + "thread_" + (++threadId));
        worker.start();
        lastExecuteTime = System.currentTimeMillis();

    }

    public void stop() {
        if (worker != null) {
            worker.stop = true;
        }
    }

    public BaseBattle get(Integer battleId) {
        return battleMap.get(battleId);
    }

    public void put(BaseBattle battle) {
        battleMap.put(battle.battleId, battle);
    }

    public BaseBattle remove(Integer battleId) {
        return battleMap.remove(battleId);
    }


    @Override
    public void run() {
        for (; ; ) {
            if (worker.stop) {
                break;
            }
            try {
                long startTime = System.currentTimeMillis();
                //执行战斗
                battleMap.values().forEach(battle -> {
                    try {
                        battle.update(startTime);
                    } catch (Throwable e) {
                        LOGGER.error(e.getMessage(), e);
                    }
                });
                lastExecuteTime = System.currentTimeMillis();
                long costTime = lastExecuteTime - startTime;

                long sleepTime = STEP_TIME - costTime;
                if (sleepTime > 0) {
                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException e) {
                        LOGGER.error(e.getMessage(), e);
                    }
                }
            } catch (Throwable e) {
                LOGGER.error(e.getMessage(), e);
            }

        }
    }

    public int size() {
        return battleMap.size();
    }

    /**
     * 检测任务是否长时间没有执行,如果是就取消当前任务，并且重新调度
     */
    public void checkLoopTimeOut() {

        if (System.currentTimeMillis() > lastExecuteTime + LOOP_TIME_OUT) {
            if (worker != null) {
                worker.goodbye();
            }
            reStart();
        }
    }


}
