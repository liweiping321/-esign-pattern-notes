package com.liwp.factory.method;

import java.util.function.Supplier;

public enum UnitType {

    HERO("hero"),
    MONSTER("moster"),
    NPC("npc");

    private final String value;

    UnitType(String value) {
        this.value = value;
    }

    public Unit create(Supplier<Unit> unitSupplier) {
        return unitSupplier.get();
    }
}
