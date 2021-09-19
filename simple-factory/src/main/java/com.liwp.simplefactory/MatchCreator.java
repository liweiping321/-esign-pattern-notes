package com.liwp.simplefactory;

public class MatchCreator {

    public static BaseMatch getMatch(int matchType) {
        switch (matchType) {
            case MatchType.MATCH_1V1:
                return new Match1V1();
            case MatchType.MATCH_5V5:
                return new Match5V5();
            default:
                throw new IllegalArgumentException("error match type:" + matchType);
        }
    }
}
