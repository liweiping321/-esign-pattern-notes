package com.liwp.singleton;

/**
 * 饿汉式模式
 */
public class Hungry {
    //将构造方法私有化
    private Hungry() {
    }
    //创建对象实例
    private static final Hungry Instance = new Hungry();

    //返回单例
    public static Hungry getInstance() {
        return Instance;
    }
}
