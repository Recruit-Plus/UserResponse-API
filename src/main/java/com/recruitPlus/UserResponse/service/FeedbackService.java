package com.recruitPlus.UserResponse.service;

import com.recruitPlus.UserResponse.respository.FeedbackRepo;
import com.recruitPlus.UserResponse.respository.UserResponseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import com.recruitPlus.UserResponse.model.Feedback;


import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepo feedbackRepo;
    @Autowired
    MongoTemplate mongoTemplate;
    public List<Feedback> getAllFeedback() {

        return feedbackRepo.findAll();
    }

    public void saveFeedback(Feedback feedback) {

        feedbackRepo.save(feedback);
    }
}
