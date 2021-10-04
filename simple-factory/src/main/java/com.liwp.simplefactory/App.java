package com.liwp.simplefactory;

public class App {

    public static  void main(String args[]){
        EnumMatchFactory.MATCH_1V1.create().match();
        EnumMatchFactory.MATCH_3V3.create().match();
        EnumMatchFactory.MATCH_5V5.create().match();
    }
}
