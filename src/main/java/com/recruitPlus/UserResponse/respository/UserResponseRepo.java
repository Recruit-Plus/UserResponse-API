package com.recruitPlus.UserResponse.respository;

import com.recruitPlus.UserResponse.model.UserResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserResponseRepo extends MongoRepository<UserResponse, String> {


}
