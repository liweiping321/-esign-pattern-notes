package com.liwp.singleton;

/**
 * 懒汉式-线程不安全
 */
public class LazyThreadUnSafe {
    //将构造方法私有化
    private LazyThreadUnSafe() {
    }
    private  static LazyThreadUnSafe Instance;

    //返回单例
    public static LazyThreadUnSafe getInstance() {
        if(Instance==null){
            Instance=new LazyThreadUnSafe();
        }
        return Instance;
    }
}
