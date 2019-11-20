package com.workshop.cache.service.client;

import com.workshop.cache.model.User;
import org.springframework.stereotype.Service;

import javax.cache.annotation.*;

@Service
@CacheDefaults(cacheName = "user")
public class ServicesClient {

    @CachePut
    public void saveNewUser(@CacheKey int id, @CacheValue User newUser) {
        newUser.updateStatus();
    }

    @CacheResult
    public User getUser(@CacheKey int id) {
        final User user = new User(id);
        user.updateStatus();
        return user;
    }

    @CacheRemove
    public void invalidate(@CacheKey int id) {
    }

    @CacheRemoveAll
    public void invalidateAll() {
    }
}
