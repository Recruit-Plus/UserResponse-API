package com.recruitPlus.UserResponse.controller;


import com.recruitPlus.UserResponse.model.UserResponse;
import com.recruitPlus.UserResponse.service.UserResponseServices;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/responses/v1")
public class UserResponseController {

    @Autowired
    private UserResponseServices userResponseServices;

    @GetMapping("/userresponse")
    public List<UserResponse> getAllUSerResponse() {
        List<UserResponse> userResponse = userResponseServices.getAllUSerResponse();
        return userResponse;

    }





}
