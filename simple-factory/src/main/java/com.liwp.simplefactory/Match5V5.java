package com.liwp.simplefactory;

public class Match5V5 extends BaseMatch {
    public Match5V5(String tag) {
        super(tag);
    }

    @Override
    public void match() {
        System.out.println(tag+"-5V5匹配");
    }
}
