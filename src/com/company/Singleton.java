package com.company;

/**
 * 利用同步来实现安全的多线程单例模式
 * 延迟加载
 * @author WuYuanshou
 */

public class Singleton {
    private static Singleton uniqueInstance;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
}
