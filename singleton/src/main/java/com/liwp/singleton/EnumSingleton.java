package com.liwp.singleton;

/**
 * 枚举单例
 */
public enum EnumSingleton {

    INSTANCE;
    @Override
    public String toString() {
        return getDeclaringClass().getCanonicalName() + "@" + hashCode();
    }
}
