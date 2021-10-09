package com.liwp.factory.method;

public class App {

    public static void main(String args[]){
        UnitCreator unitCreator=new PVEUnitCreator();
        for(UnitType type: UnitType.values()){
            Unit unit= unitCreator.create(type);
            System.out.println(unitCreator.getClass().getSimpleName()+" "+unit);
        }
        System.out.println("*******************************************************");
        unitCreator=new PVPUnitCreator();
        for(UnitType type: UnitType.values()){
            Unit unit= unitCreator.create(type);
            System.out.println(unitCreator.getClass().getSimpleName()+" "+unit);
        }
    }
}
