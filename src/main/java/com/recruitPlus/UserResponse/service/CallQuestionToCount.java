package com.recruitPlus.UserResponse.service;

import com.recruitPlus.UserResponse.model.Question;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class CallQuestionToCount {
    static RestTemplate restTemplate = new RestTemplate();
    static String baseUrl = "http://localhost:8081/questions/v1/";
    static String baseUrl1="http://localhost:8084/users/v1/";

    static Object getQuestionsByIdByExchangeMethod(String questionId) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Object> responseEntity = restTemplate.exchange(baseUrl + "question/"+questionId ,
                HttpMethod.GET,
                requestEntity,
                Object.class);
        Object questions = responseEntity.getBody();
        return questions;
    }
    static Object getQuestionsByIdByExchangeMethod1(String user_id) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Object> responseEntity = restTemplate.exchange(baseUrl1 + "users/"+user_id ,
                HttpMethod.GET,
                requestEntity,
                Object.class);
        Object user= responseEntity.getBody();
        return user;
    }


}
