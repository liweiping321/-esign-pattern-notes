package com.liwp.simplefactory;

abstract  class BaseMatch {
    protected final String tag;

    public BaseMatch(String tag) {
        this.tag = tag;
    }

    public abstract void match();
}
