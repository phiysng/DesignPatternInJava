package com.company;

public class HurrySingleton {
    private static HurrySingleton uniqueInstance = new HurrySingleton();

    private HurrySingleton() {
    }

    public static HurrySingleton getInstance() {
        return uniqueInstance;
    }
}
