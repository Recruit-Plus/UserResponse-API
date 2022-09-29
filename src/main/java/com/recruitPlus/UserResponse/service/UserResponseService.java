package com.recruitPlus.UserResponse.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recruitPlus.UserResponse.UserDto.UserResponsesDto;
import com.recruitPlus.UserResponse.exception.UserResponseNotFoundException;
import com.recruitPlus.UserResponse.model.UserResponse;
import com.recruitPlus.UserResponse.model.UserSubmissions;
import com.recruitPlus.UserResponse.respository.UserResponseRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserResponseService {

    @Autowired
    private UserResponseRepo userResponseRepo;
    @Autowired
    MongoTemplate mongoTemplate;

    public List<UserResponse> getAllUSerResponse() {

        return userResponseRepo.findAll();
    }

    public UserResponse NewUserResponse(UserResponse userResponse) {
        List<UserSubmissions> resp = userResponse.getResponseSubmitted();
        int n = resp.size();
        int score = 0;
        for (int i = 0; i < n; i++) {
            Object question = CallQuestionToCount.getQuestionsByIdByExchangeMethod(resp.get(i).getQuestionId());
            ObjectMapper oMapper = new ObjectMapper();
            Map<String, Object> map = oMapper.convertValue(question, Map.class);
            List ques = new ArrayList(map.values());
            List<String> crtAns = oMapper.convertValue(ques.get(3), List.class);
            List<String> userAns = oMapper.convertValue(resp.get(i).getAnswer_submitted(), List.class);
            Collections.sort(crtAns);
            Collections.sort(userAns);
            if (crtAns.equals(userAns)) {
                score = score + (int) ques.get(6);
            }
        }
        userResponse.setScore(score);
        return userResponseRepo.save(userResponse);

    }

    public void updateUserResponse(String responseId, UserResponse userResponse) {
        UserResponse findById = userResponseRepo.findById(responseId)
                .orElseThrow(() -> new UserResponseNotFoundException(responseId));

        findById.setScore(userResponse.getScore());

        userResponseRepo.save(findById);
    }

    public List<UserResponsesDto> getResponsesByAssessmentId(String assessment_id) {
        List<UserResponse> responses = userResponseRepo.findAll();
        List<UserResponsesDto> userData = new ArrayList<>();
        for (UserResponse resp : responses) {
            String assessment=resp.getAssessment_id();
            if (assessment.equals(assessment_id)) {
                UserResponsesDto dto = new UserResponsesDto();
                BeanUtils.copyProperties(resp, dto);
                System.out.println(dto.getUser_id());
                System.out.println(dto.getScore());
                System.out.println(dto.getTime_taken());
                Object user = CallQuestionToCount.getQuestionsByIdByExchangeMethod1(resp.getUser_id());
                ObjectMapper oMapper = new ObjectMapper();
                Map<String, Object> map = oMapper.convertValue(user, Map.class);
                List user1 = new ArrayList(map.values());
                dto.setUser_name(oMapper.convertValue(user1.get(1), String.class));
                dto.setEmail(oMapper.convertValue(user1.get(2), String.class));
                dto.setCollege_name(oMapper.convertValue(user1.get(3), String.class));
                userData.add(dto);


            }
        }
        return userData;
    }
}

