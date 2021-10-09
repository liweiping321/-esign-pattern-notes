package com.liwp.factory.method;

public class PVEUnit extends Unit {
    public PVEUnit(UnitType unitType) {
        super(unitType);
    }

    public String toString(){
        return "PVEUnit-"+getUnitType().name();
    }
}
