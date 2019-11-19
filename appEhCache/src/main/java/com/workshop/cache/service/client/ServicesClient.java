package com.workshop.cache.service.client;

import com.workshop.cache.config.ServicesProperties;
import com.workshop.cache.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


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

    @Cacheable(cacheNames = "code", cacheManager = "jCacheCacheManager")
    public String callGetCodeService(String name) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(servicesProperties.getCodeServiceURL())
                // Add query parameter
                .queryParam("name", name);

        return restTemplate.getForObject(builder.toUriString(), String.class);
    }
}
