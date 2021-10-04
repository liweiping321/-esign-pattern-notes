package com.liwp.simplefactory;

public class Match3V3 extends BaseMatch {
    public Match3V3(String tag) {
        super(tag);
    }

    @Override
    public void match() {
        System.out.println(tag+"-3V3匹配");
    }
}
