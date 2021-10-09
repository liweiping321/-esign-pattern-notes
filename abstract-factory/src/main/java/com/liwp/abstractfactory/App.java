package com.liwp.abstractfactory;

public class App {

    public static void main(String args[]){
        Country country=CountryFactory.createCountry(CountryType.WEI);
        System.out.println(country.getInfo());

        country=CountryFactory.createCountry(CountryType.WU);
        System.out.println(country.getInfo());
    }
}
