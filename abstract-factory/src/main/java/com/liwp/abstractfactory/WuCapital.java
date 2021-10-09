package com.liwp.abstractfactory;

public class WuCapital implements Capital {
    private static final String INFO="吴国都城";
    @Override
    public String getInfo() {
        return INFO;
    }
}
