package com.liwp.simplefactory;

/**
 * 枚举工厂
 */
public enum EnumMatchFactory {
    MATCH_1V1() {
        @Override
        BaseMatch create() {
            return new Match1V1(MatchConst.TAG_ENUM);
        }
    },
    MATCH_3V3() {
        @Override
        BaseMatch create() {
            return new Match3V3(MatchConst.TAG_ENUM);
        }
    },
    MATCH_5V5() {
        @Override
        BaseMatch create() {
            return new Match5V5(MatchConst.TAG_ENUM);
        }
    };

    abstract BaseMatch create();
}
