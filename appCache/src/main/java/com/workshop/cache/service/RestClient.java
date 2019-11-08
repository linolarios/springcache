package com.workshop.cache.service;

import com.workshop.cache.model.User;
import com.workshop.cache.service.client.ServicesClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestClient {

    @Autowired
    ServicesClient servicesClient;

    public List<User> getUsersList() {

        return servicesClient.callListUserService();
    }

    public String getCodeWithName(String name){
        return servicesClient.callGetCodeService(name);
    }

}
