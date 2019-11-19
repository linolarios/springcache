package com.workshop.cache.repository;

import com.workshop.cache.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepository.class);

    @Value("${query.select}")
    private String selectAllUsers;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> getUsers() {
        LOGGER.info("**** Querying DB for users ****");

        return jdbcTemplate.query(
                selectAllUsers,
                (rs, rowNum) ->
                        new User(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("email")
                        )
        );
    }

    public void saveUser(User newUser) {
        LOGGER.info("**** Save new user ****");

    }

    public User findUser(String name) {
        LOGGER.info("**** finding user ****");
        return null;
    }
}
