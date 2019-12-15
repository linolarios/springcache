package com.workshop.cache.service;


import com.workshop.cache.singleton.AdminDoubleCheckSingleton;
import com.workshop.cache.singleton.AdminEnumSingleton;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SigletonTest {

    @Test
    void testOnlyOneInstanceIsCreated() {
        final AdminEnumSingleton adminEnumSingleton = AdminEnumSingleton.getInstance();

        Assertions.assertSame(adminEnumSingleton, AdminEnumSingleton.getInstance());
        Assertions.assertSame(AdminDoubleCheckSingleton.getInstance(), AdminDoubleCheckSingleton.getInstance());
    }

    @Test
    void testHashIsTheSame() {
        final AdminEnumSingleton adminEnumSingleton = AdminEnumSingleton.getInstance();
        Assertions.assertEquals(adminEnumSingleton.hashCode(), AdminEnumSingleton.getInstance().hashCode());
        Assertions.assertEquals(AdminDoubleCheckSingleton.getInstance().hashCode(), AdminDoubleCheckSingleton.getInstance().hashCode());
    }

    @Test
    void testObjectsAreEquals() {
        Assertions.assertSame(AdminEnumSingleton.getInstance(), AdminEnumSingleton.getInstance());
        Assertions.assertSame(AdminDoubleCheckSingleton.getInstance(), AdminDoubleCheckSingleton.getInstance());
    }
}
