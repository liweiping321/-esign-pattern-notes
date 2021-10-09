package com.liwp.abstractfactory;

public interface CountryFactory {

    Lord createLord();

    Capital createCapital();

    Army createArmy();

    public static Country createCountry(CountryType type) {
        CountryFactory factory = type.createFactory();
        Country country = new Country();
        country.setLord(factory.createLord());
        country.setCapital(factory.createCapital());
        country.setArmy(factory.createArmy());
        return country;
    }


}
