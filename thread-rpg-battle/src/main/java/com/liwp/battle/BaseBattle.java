package com.liwp.battle;

import com.liwp.battle.actuator.IUpdate;

import java.util.concurrent.atomic.AtomicInteger;

public class BaseBattle implements IUpdate {
    private final static AtomicInteger SEQUENCE = new AtomicInteger();

    public final int battleId;

    public BaseBattle(){
        battleId=SEQUENCE.incrementAndGet();
    }
    @Override
    public void update(long now) {

    }
}
