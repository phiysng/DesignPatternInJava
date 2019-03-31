package com.company;

/**
 * 利用双重检查加锁来实现安全的多线程单例模式
 *
 * @author WuYuanshou
 */

public class DoubleLockSingleton {
    private volatile static DoubleLockSingleton uniqueInstance;

    private DoubleLockSingleton() {
    }

    public static DoubleLockSingleton getInstance() {
        //如果类还没有被创建
        if (uniqueInstance == null) {
            //在这里同步多个线程 同一时刻只有一个线程能够进入下面的代码
            synchronized (DoubleLockSingleton.class) {
                //进程申请进入这段代码时实例未创建 但是在其进入这段代码前可能其他进程已经进入
                //这段代码并创建了实例 所以这里进行第二次检查
                if (uniqueInstance == null) {
                    uniqueInstance = new DoubleLockSingleton();
                }
            }
        }
        return uniqueInstance;
    }
}