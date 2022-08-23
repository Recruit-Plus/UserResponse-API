package com.recruitPlus.UserResponse.service;

import com.recruitPlus.UserResponse.exception.UserResponseNotFoundException;
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
    public UserResponse NewUserResponse(UserResponse userResponse){
        return userResponseRepo.save(userResponse);
    }
    public void updateUserResponse(String responseId,UserResponse userResponse){
        UserResponse findById=userResponseRepo.findById(responseId)
                .orElseThrow(()->new UserResponseNotFoundException(responseId));

        findById.setScore(userResponse.getScore());

        userResponseRepo.save(findById);
    }
}
