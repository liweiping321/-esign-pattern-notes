package com.liwp.abstractfactory;

public class WeiCapital implements Capital {
    private static final String INFO="魏国都城";

    @Override
    public String getInfo() {
        return INFO;
    }
}
