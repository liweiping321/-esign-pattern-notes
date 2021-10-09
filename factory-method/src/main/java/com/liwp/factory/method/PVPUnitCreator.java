package com.liwp.factory.method;

public class PVPUnitCreator implements UnitCreator {
    @Override
    public Unit create(UnitType unityType) {
        return unityType.create(() -> new PVPUnit(unityType));
    }
}
