package com.recruitPlus.UserResponse.controller;


import com.recruitPlus.UserResponse.UserDto.UserResponsesDto;
import com.recruitPlus.UserResponse.model.*;
import com.recruitPlus.UserResponse.service.UserResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/responses/v1")
public class UserResponseController {

    @Autowired
    private UserResponseService userResponseService;

    @GetMapping("/user/response")
    public List<UserResponse> getAllUSerResponse() {
        List<UserResponse> userResponseList=userResponseService.getAllUSerResponse();
        return userResponseList;

    }



    @PostMapping("/user/response")
    @ResponseStatus(code= HttpStatus.CREATED)
    public int saveUserResponse(@RequestBody UserResponse userResponse){
        int score= userResponseService.NewUserResponse(userResponse).getScore();
        return score;
    }

    @PutMapping("/user/response/{response_id}")
    public void UpdateByResponseId(@RequestBody UserResponse userResponse, @PathVariable(value = "response_id") String responseId){
        userResponseService.updateUserResponse(responseId,userResponse);
    }

    @GetMapping("/responses/{assessment_id}")
    public List<UserResponsesDto> getResponsesByAssessmentId(@PathVariable String assessment_id){
        return userResponseService.getResponsesByAssessmentId(assessment_id);

    }






}
