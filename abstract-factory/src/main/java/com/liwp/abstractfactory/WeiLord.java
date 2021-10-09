package com.liwp.abstractfactory;

public class WeiLord implements Lord {
    private static final String INFO="魏国主公";

    @Override
    public String getInfo() {
        return INFO;
    }
}
