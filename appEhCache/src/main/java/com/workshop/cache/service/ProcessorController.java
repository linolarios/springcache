package com.workshop.cache.service;

import com.workshop.cache.listener.CacheListener;
import com.workshop.cache.processor.CustomEntryProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.FactoryBuilder;
import javax.cache.configuration.MutableCacheEntryListenerConfiguration;
import javax.cache.configuration.MutableConfiguration;
import java.util.Iterator;

@RestController
public class ProcessorController {

    private final Logger LOG = LoggerFactory.getLogger(ProcessorController.class);

    @RequestMapping("/cacheProcessor")
    public void modifyValues() {
        CacheManager cacheManager = Caching.getCachingProvider().getCacheManager();

        MutableConfiguration mutableConfiguration = new MutableConfiguration();
        mutableConfiguration.setTypes(String.class, String.class) //
                .addCacheEntryListenerConfiguration(new MutableCacheEntryListenerConfiguration( //
                        FactoryBuilder.factoryOf(CacheListener.class), null, false, true));

        Cache cache = cacheManager.createCache("cache1", mutableConfiguration);
        cache.put("key1", "value1");
        cache.put("key2", "value2");
        cache.put("key3", "value3");

        cache.put("key4", "value4");

        Iterator<Cache.Entry> iterator = cache.iterator();
        while (iterator.hasNext()) {
            Cache.Entry entry = iterator.next();
            LOG.info(entry.getKey() + ":" + entry.getValue());
        }

        String oldValue = (String) cache.invoke("key1", new CustomEntryProcessor(), "change");
        LOG.info("Old value: " + oldValue);

        iterator = cache.iterator();
        while (iterator.hasNext()) {
            Cache.Entry entry = iterator.next();
            LOG.info(entry.getKey() + ":" + entry.getValue());
        }

        Caching.getCachingProvider().getCacheManager().getCache("cache1").close();
    }


}
