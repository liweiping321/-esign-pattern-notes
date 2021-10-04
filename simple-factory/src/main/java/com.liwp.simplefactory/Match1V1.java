package com.liwp.simplefactory;

public class Match1V1 extends BaseMatch {

    public Match1V1(String tag) {
        super(tag);
    }

    @Override
    public void match() {
        System.out.println(tag+"-1V1匹配");
    }
}
