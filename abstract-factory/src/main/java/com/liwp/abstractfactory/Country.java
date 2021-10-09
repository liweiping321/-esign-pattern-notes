package com.liwp.abstractfactory;

public class Country {
    /**主公*/
    private Lord lord;
    /**都城*/
    private Capital capital;
    /**军队*/
    private Army army;

    public Lord getLord() {
        return lord;
    }

    public void setLord(Lord lord) {
        this.lord = lord;
    }

    public Capital getCapital() {
        return capital;
    }

    public void setCapital(Capital capital) {
        this.capital = capital;
    }

    public Army getArmy() {
        return army;
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    public String getInfo() {
        return lord.getInfo() + "->" + capital.getInfo() + "->" + army.getInfo();
    }
}
