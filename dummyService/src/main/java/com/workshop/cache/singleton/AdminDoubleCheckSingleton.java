package com.workshop.cache.singleton;

import com.workshop.cache.model.Admin;

import java.util.HashMap;
import java.util.Objects;

public final class AdminDoubleCheckSingleton {


    private AdminDoubleCheckSingleton() {
    }

    private volatile static Admin _instance;

    public static Admin getInstance() {
        if (Objects.isNull(_instance)) {
            synchronized (AdminDoubleCheckSingleton.class) {
                if (Objects.isNull(_instance)) {
                    _instance = new Admin();
                }
            }
        }
        return _instance;
    }
}
