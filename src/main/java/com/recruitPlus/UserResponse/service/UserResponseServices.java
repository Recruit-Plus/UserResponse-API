package com.recruitPlus.UserResponse.service;

import com.recruitPlus.UserResponse.model.UserResponse;
import com.recruitPlus.UserResponse.respository.UserResponseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserResponseServices {

    @Autowired
    private UserResponseRepo userResponseRepo;
    @Autowired
    MongoTemplate mongoTemplate;

    public List<UserResponse> getAllUSerResponse() {
        return userResponseRepo.findAll();

    }
}
