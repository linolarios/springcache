package com.workshop.cache.service;

import com.workshop.cache.model.User;
import com.workshop.cache.service.client.ServicesClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListenerCacheController {

    private final Logger LOG = LoggerFactory.getLogger(ListenerCacheController.class);

    @Autowired
    ServicesClient servicesClient;

    @RequestMapping("/testLogger")
    public void triggerCacheEvents(@RequestParam(name = "id", required = true) int id) {
        LOG.info("Saving first object");
        servicesClient.saveNewUser(id, new User(id));
        LOG.info(print(servicesClient.getUser(id)));
        LOG.info(print(servicesClient.getUser(id)));
        LOG.info(print(servicesClient.getUser(id)));

        LOG.info("Saving second object");
        servicesClient.saveNewUser(id + 1, new User(id + 1));
        LOG.info(print(servicesClient.getUser(id + 1)));
        LOG.info(print(servicesClient.getUser(id + 1)));
        LOG.info(print(servicesClient.getUser(id + 1)));

        LOG.info("Invalidating object: " + id);
        servicesClient.invalidate(id);
        LOG.info("Retrieve  object using id: " + id);
        LOG.info(print(servicesClient.getUser(id)));
        LOG.info("Retrieve  object using id: " + (id + 1));
        LOG.info(print(servicesClient.getUser(id + 1)));
        LOG.info("Invalidate all cache");
        servicesClient.invalidateAll();

        LOG.info("Getting object using same ids");
        LOG.info(print(servicesClient.getUser(id)));
        LOG.info(print(servicesClient.getUser(id + 1)));

        LOG.info("Invalidate all cache");
        servicesClient.invalidateAll();
        LOG.info("END");
    }


    private String print(User user) {
        return user.toString();
    }

}
