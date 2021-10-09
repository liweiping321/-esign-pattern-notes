package com.liwp.factory.method;

public abstract class Unit {
    private final UnitType unitType;

    public Unit(UnitType unitType) {
        this.unitType = unitType;
    }


    public UnitType getUnitType() {
        return unitType;
    }
}
