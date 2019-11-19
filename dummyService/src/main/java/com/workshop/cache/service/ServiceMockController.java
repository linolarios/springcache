package com.workshop.cache.service;

import com.workshop.cache.model.User;
import com.workshop.cache.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//This is a dummy controller only for educational purposes
@RestController
public class ServiceMockController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceMockController.class);

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/getCode")
    public String getThirdPartyService(@RequestParam(name = "name", required = false) String name) {
        LOGGER.info("Getting Code:" + name);

        return "code: ABCDE " + name;
    }

    @RequestMapping("/listUsers")
    public List<User> getDataBaseUsers() {
        LOGGER.info("Getting DB users");

        return userRepository.getUsers();
    }
}