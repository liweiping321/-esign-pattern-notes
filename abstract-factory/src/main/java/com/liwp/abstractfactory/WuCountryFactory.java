package com.liwp.abstractfactory;

public class WuCountryFactory implements CountryFactory {
    @Override
    public Lord createLord() {
        return new WuLord();
    }

    @Override
    public Capital createCapital() {
        return new WuCapital();
    }

    @Override
    public Army createArmy() {
        return new WuArmy();
    }
}
