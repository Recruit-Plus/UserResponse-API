package com.recruitPlus.UserResponse.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recruitPlus.UserResponse.exception.UserResponseNotFoundException;
import com.recruitPlus.UserResponse.model.UserResponse;
import com.recruitPlus.UserResponse.model.UserSubmissions;
import com.recruitPlus.UserResponse.respository.UserResponseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import java.util.*;

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
        List<UserSubmissions> resp=userResponse.getResponseSubmitted();
        int n= resp.size();
        int score=0;
        for (int i=0;i<n;i++){
            Object question=CallQuestionToCount.useExchangeMethodsOfRestTemplate(resp.get(i).getQuestionId());
            ObjectMapper oMapper = new ObjectMapper();
            Map<String, Object> map = oMapper.convertValue(question, Map.class);
            List ques= new ArrayList(map.values());
            List<String> crtAns=oMapper.convertValue(ques.get(3),List.class);
            List<String> userAns=oMapper.convertValue(resp.get(i).getAnswer_submitted(),List.class);
            Collections.sort(crtAns);
            Collections.sort(userAns);
            if(crtAns.equals(userAns)){
               score =score + (int) ques.get(6);
            }
        }
        userResponse.setScore(score);
       return userResponseRepo.save(userResponse);

    }
    public void updateUserResponse(String responseId,UserResponse userResponse){
        UserResponse findById=userResponseRepo.findById(responseId)
                .orElseThrow(()->new UserResponseNotFoundException(responseId));

        findById.setScore(userResponse.getScore());

        userResponseRepo.save(findById);
    }
}
