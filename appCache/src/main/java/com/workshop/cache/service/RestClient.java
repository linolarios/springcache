package com.workshop.cache.service;

import com.workshop.cache.model.User;
import com.workshop.cache.service.client.ServicesClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestClient {

    @Autowired
    ServicesClient servicesClient;

    @RequestMapping("/getUsersList")
    public List<User> getUsersList() {
        return servicesClient.callListUserService();
    }

    @RequestMapping("/getCode")
    public String getCodeWithName(@RequestParam(name = "name", required = false) String name) {
        return servicesClient.callGetCodeService(name);
    }

}
