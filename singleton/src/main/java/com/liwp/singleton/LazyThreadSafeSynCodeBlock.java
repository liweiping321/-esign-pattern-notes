package com.liwp.singleton;

/**
 * 懒汉式-线程安全-同步代码块
 */
public class LazyThreadSafeSynCodeBlock {
    //将构造方法私有化
    private LazyThreadSafeSynCodeBlock() {
    }
    private  static LazyThreadSafeSynCodeBlock Instance;


    public synchronized LazyThreadSafeSynCodeBlock getInstance() {
        if(Instance==null){
            synchronized (LazyThreadSafeSynCodeBlock.class){
                Instance=new LazyThreadSafeSynCodeBlock();
            }
        }
        return Instance;
    }
}
