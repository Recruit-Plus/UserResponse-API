package com.recruitPlus.UserResponse.respository;

import com.recruitPlus.UserResponse.model.Feedback;
import com.recruitPlus.UserResponse.model.UserResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepo extends MongoRepository<Feedback, String> {
}
