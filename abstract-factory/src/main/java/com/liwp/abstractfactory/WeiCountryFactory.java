package com.liwp.abstractfactory;

public class WeiCountryFactory implements CountryFactory {
    @Override
    public Lord createLord() {
        return new WeiLord();
    }

    @Override
    public Capital createCapital() {
        return new WeiCapital();
    }

    @Override
    public Army createArmy() {
        return new WeiArmy();
    }
}
