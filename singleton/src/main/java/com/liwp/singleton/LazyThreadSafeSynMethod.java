package com.liwp.singleton;

/**
 * 懒汉式-线程安全-同步方法
 */
public class LazyThreadSafeSynMethod {
    //将构造方法私有化
    private LazyThreadSafeSynMethod() {
    }
    private  static LazyThreadSafeSynMethod Instance;

    //同步方法，解决线程不一致问题
    public synchronized LazyThreadSafeSynMethod getInstance() {
        if(Instance==null){
            Instance=new LazyThreadSafeSynMethod();
        }
        return Instance;
    }
}
