package com.liwp.abstractfactory;

public class WeiArmy implements Army {

    private static final String INFO="魏国军队";

    @Override
    public  String getInfo() {
        return INFO;
    }
}
