package com.recruitPlus.UserResponse.controller;


import com.recruitPlus.UserResponse.model.*;
//import com.recruitPlus.UserResponse.model.ResponseSubmitted;
import com.recruitPlus.UserResponse.service.UserResponseServices;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/responses/v1")
public class UserResponseController {

    @Autowired
    private UserResponseServices userResponseServices;

    @GetMapping("/user/response")
    public List<UserResponse> getAllUSerResponse() {
        List<UserResponse> userResponseList=userResponseServices.getAllUSerResponse();
        return userResponseList;

    }
    @PostMapping("/user/response")
    @ResponseStatus(code= HttpStatus.CREATED)
    public UserResponse saveUserResponse(@RequestBody UserResponse userResponse){
        UserResponse saveUserResponse= userResponseServices.NewUserResponse(userResponse);
        return userResponse;
    }
    @PutMapping("/user/response/{response_id}")
    public void UpdateByResponseId(@RequestBody UserResponse userResponse, @PathVariable(value = "response_id") String responseId){
        userResponseServices.updateUserResponse(responseId,userResponse);
    }





}
