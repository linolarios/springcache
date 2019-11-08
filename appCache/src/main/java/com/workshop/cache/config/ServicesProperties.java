package com.workshop.cache.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "services.url")
public class ServicesProperties {

    private String lisUsersServiceURL;
    private String codeServiceURL;

    public String getLisUsersServiceURL() {
        return lisUsersServiceURL;
    }

    public void setLisUsersServiceURL(String lisUsersServiceURL) {
        this.lisUsersServiceURL = lisUsersServiceURL;
    }

    public String getCodeServiceURL() {
        return codeServiceURL;
    }

    public void setCodeServiceURL(String codeServiceURL) {
        this.codeServiceURL = codeServiceURL;
    }
}
