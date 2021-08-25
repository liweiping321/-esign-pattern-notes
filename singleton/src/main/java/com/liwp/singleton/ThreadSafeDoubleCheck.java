package com.liwp.singleton;

/**
 * 双重检查
 */
public class ThreadSafeDoubleCheck {
    //将构造方法私有化
    private ThreadSafeDoubleCheck() {
        if(Instance==null){
            Instance=this;
        }else{
            throw new IllegalStateException("Already initialized.");
        }
    }
    //加上volatile 解决指令重排问题
    private  volatile static ThreadSafeDoubleCheck Instance;

    //解决线程不一致问题
    public  ThreadSafeDoubleCheck getInstance() {
        if (Instance == null) {
            synchronized (ThreadSafeDoubleCheck.class) {
                if (Instance == null) {
                    Instance = new ThreadSafeDoubleCheck();
                }
            }
        }
        return Instance;
    }
}
