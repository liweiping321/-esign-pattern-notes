package com.liwp.abstractfactory;

public class WuLord implements Lord {
    private static final String INFO="魏国主公";
    @Override
    public String getInfo() {
        return INFO;
    }
}
