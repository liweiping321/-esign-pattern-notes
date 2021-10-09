package com.liwp.factory.method;

public class PVPUnit extends Unit {
    public PVPUnit(UnitType unitType) {
        super(unitType);
    }

    public String toString(){
        return "PVPUnit-"+getUnitType().name();
    }
}
