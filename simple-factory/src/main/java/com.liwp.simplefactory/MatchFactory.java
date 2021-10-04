package com.liwp.simplefactory;

public class MatchFactory {

    public static BaseMatch create(int matchType) {
        switch (matchType) {
            case MatchConst.MATCH_1V1:
                return new Match1V1(MatchConst.TAG_SIMPLE);
            case MatchConst.MATCH_3V3:
                return new Match3V3(MatchConst.TAG_SIMPLE);
            case MatchConst.MATCH_5V5:
                return new Match5V5(MatchConst.TAG_SIMPLE);
            default:
                throw new IllegalArgumentException("error match type:" + matchType);
        }
    }
}
