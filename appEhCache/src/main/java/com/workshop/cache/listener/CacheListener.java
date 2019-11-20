package com.workshop.cache.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.cache.event.*;
import java.util.Iterator;

@Component
public class CacheListener implements CacheEntryCreatedListener,
        CacheEntryUpdatedListener, CacheEntryExpiredListener,
        CacheEntryRemovedListener {

    private final Logger LOG = LoggerFactory.getLogger(CacheListener.class);

    @Override
    public void onCreated(Iterable iterable) throws CacheEntryListenerException {
        LOG.info("CREATE");
        final Iterator iterator = iterable.iterator();
        for (; iterator.hasNext(); ) {
            CacheEntryEvent cacheEntryEvent = (CacheEntryEvent) iterator.next();
            LOG.info("Key: {} | EventType: {}  | Value: {} |",
                    cacheEntryEvent.getKey(), cacheEntryEvent.getEventType(),
                    cacheEntryEvent.getValue());
        }
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
