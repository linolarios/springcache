package com.workshop.cache.builder;

import com.workshop.cache.model.User;

import java.util.function.Consumer;

public class UserBuilder {

    public int id;
    public String name;
    public String email;
    public boolean isActive;

    public UserBuilder with(Consumer<UserBuilder> builderFunction) {
        builderFunction.accept(this);
        return this;
    }

    public User createUser() {
        return new User(id, name, email);
    }
}
