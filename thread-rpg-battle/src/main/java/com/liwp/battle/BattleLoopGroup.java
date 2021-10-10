package com.liwp.battle.actuator;

import com.liwp.battle.BaseBattle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Consumer;

public class BattleLoopGroup implements Runnable {
    private static final Logger LOGGER = LogManager.getLogger(BattleLoopGroup.class);

    private BattleLoop[] loops;

    private final LoopThread loopGuard;

    private volatile boolean stop;

    public BattleLoopGroup() {
        loopGuard = new LoopThread(this, "loopGuard");
    }

    public void start(int loopNum) {
        loops = new BattleLoop[loopNum];
        for (int i = 0; i < loopNum; i++) {
            loops[i] = new BattleLoop(i);
        }
        loopGuard.start();
    }

    public void stop() {
        stop = true;
        runFunc(loop -> loop.stop());
    }

    @Override
    public void run() {
        for (; ; ) {
            if (stop) {
                break;
            }
            //runFunc(loop -> loop.checkLoopTimeOut());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
    }

    private void runFunc(Consumer<BattleLoop> consumer) {
        for (BattleLoop battleLoop : loops) {
            consumer.accept(battleLoop);
        }
    }

    private BattleLoop getLoop(int battleId) {
        return loops[battleId % loops.length];
    }

    public void put(BaseBattle battle) {
        getLoop(battle.battleId).put(battle);
    }
}
