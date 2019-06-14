package com.example.user.service;

import java.util.List;

import com.example.common.domain.User;
import com.fasterxml.jackson.databind.JsonNode;


public interface UserService {

    User findById(Long id);

    List<User> findAll();

    void save(User product);

    void update(User product);

    void delete(Long id);

	JsonNode findOrder(Long id);

	JsonNode findProduct(Long id);

}
