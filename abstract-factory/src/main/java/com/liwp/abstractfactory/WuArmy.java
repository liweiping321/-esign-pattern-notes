package com.liwp.abstractfactory;

public class WuArmy implements Army {
    private static final String INFO="吴国军队";
    @Override
    public String getInfo() {
        return INFO;
    }
}
