package com.liwp.singleton;

/**
 * 静态内部类
 */
public class StaticInnerClassHolder {

    private StaticInnerClassHolder(){
    }

    public static StaticInnerClassHolder getInstance() {
        return Holder.Instance;
    }

    /**
     * 延迟加载单例对象
     */
    private static class Holder{
        private static final StaticInnerClassHolder Instance = new StaticInnerClassHolder();
    }
}
