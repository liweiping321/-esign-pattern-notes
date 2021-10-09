package com.liwp.factory.method;

public class PVEUnitCreator implements UnitCreator {
    @Override
    public Unit create(UnitType unityType) {
        return unityType.create(()->new PVEUnit(unityType));
    }

}
