package com.liwp.abstractfactory;

public enum CountryType {
    WU("吴") {
        @Override
        CountryFactory createFactory() {
            return new WuCountryFactory();
        }
    },
    WEI("魏") {
        @Override
        CountryFactory createFactory() {
            return new WeiCountryFactory();
        }
    };

    abstract CountryFactory createFactory();

    private final String value;

    CountryType(String value) {
        this.value = value;
    }
}
