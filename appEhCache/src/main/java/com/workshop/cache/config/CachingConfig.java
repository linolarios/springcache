package com.workshop.cache.config;

import com.workshop.cache.listener.CacheListener;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.FactoryBuilder;
import javax.cache.configuration.MutableCacheEntryListenerConfiguration;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.CreatedExpiryPolicy;
import javax.cache.expiry.Duration;
import javax.cache.spi.CachingProvider;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CachingConfig {

    @Bean
    JCacheCacheManager jCacheCacheManager() {
        return new JCacheCacheManager(cacheManager());
    }

    @Bean
    CacheManager cacheManager() {
        CachingProvider provider = Caching.getCachingProvider();
        CacheManager cacheManager = provider.getCacheManager();

        MutableConfiguration cacheConfiguration = new MutableConfiguration()
                .addCacheEntryListenerConfiguration(cacheEntryListener())
                .setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(new Duration(TimeUnit.SECONDS, 30)));

        cacheManager.createCache("user", cacheConfiguration);

        return cacheManager;
    }

    @Bean
    public MutableCacheEntryListenerConfiguration cacheEntryListener() {
        return new MutableCacheEntryListenerConfiguration(
                FactoryBuilder.factoryOf(CacheListener.class), null, false, true);
    }


}
