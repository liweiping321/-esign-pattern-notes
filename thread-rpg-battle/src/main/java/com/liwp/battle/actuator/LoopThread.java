package com.liwp.battle.actuator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoopThread extends Thread {
    private static final Logger LOGGER = LogManager.getLogger(BattleLoopGroup.class);
    public volatile boolean stop = false;

    public LoopThread(Runnable target, String name) {
        super(target, name);
    }

    public void goodbye() {
        stop = true;
        try {
            stop();
        } catch (Throwable e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}