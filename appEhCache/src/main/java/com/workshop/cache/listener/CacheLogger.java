package com.workshop.cache.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.cache.event.*;

@Component
public class CacheLogger implements CacheEntryCreatedListener,
        CacheEntryUpdatedListener, CacheEntryExpiredListener,
        CacheEntryRemovedListener {

    private final Logger LOG = LoggerFactory.getLogger(CacheLogger.class);

    @Override
    public void onCreated(Iterable iterable) throws CacheEntryListenerException {
        LOG.info("CREATE");
    }

    @Override
    public void onExpired(Iterable iterable) throws CacheEntryListenerException {
        LOG.info("EXPIRE");
    }

    @Override
    public void onRemoved(Iterable iterable) throws CacheEntryListenerException {
        LOG.info("REMOVED");
    }

    @Override
    public void onUpdated(Iterable iterable) throws CacheEntryListenerException {
        LOG.info("UPDATED");
    }

}
