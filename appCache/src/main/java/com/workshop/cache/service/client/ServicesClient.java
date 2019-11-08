package com.workshop.cache.service.client;

import com.workshop.cache.config.ServicesProperties;
import com.workshop.cache.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ServicesClient {


    @Autowired
    private ServicesProperties servicesProperties;
    private RestTemplate restTemplate = new RestTemplate();


    public List callListUserService() {
        return restTemplate.exchange(//
                servicesProperties.getLisUsersServiceURL(), //
                HttpMethod.GET, //
                null, //
                new ParameterizedTypeReference<List<User>>() {
                }) //
                .getBody();
    }

    public String callGetCodeService(String name) {
        return restTemplate.getForObject(servicesProperties.getCodeServiceURL(), String.class, name);
    }
}
