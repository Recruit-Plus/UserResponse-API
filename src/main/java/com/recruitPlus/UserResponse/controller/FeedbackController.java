package com.recruitPlus.UserResponse.controller;

import com.recruitPlus.UserResponse.model.Feedback;
import com.recruitPlus.UserResponse.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
@RequestMapping("/responses/v1")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/feedbacks")
    @ResponseBody
    public List<Feedback> getAllFeedback(){
        List<Feedback> feedbacks=feedbackService.getAllFeedback();
        return feedbacks;
    }

    @PostMapping("/feedbacks")
    @ResponseBody
    public ResponseEntity<Object> saveFeedback(@RequestBody Feedback feedback)
    {
        feedbackService.saveFeedback(feedback);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
