package com.workshop.cache.singleton;

import com.workshop.cache.model.Admin;

public enum AdminEnumSingleton {
    INSTANCE;

    private final Admin admin;

    AdminEnumSingleton() {
        admin = new Admin();
    }

    public static AdminEnumSingleton getInstance() {
        return INSTANCE;
    }
}
