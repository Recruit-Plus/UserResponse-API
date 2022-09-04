package com.recruitPlus.UserResponse.service;

import com.recruitPlus.UserResponse.model.Question;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class CallQuestionToCount {
    static RestTemplate restTemplate = new RestTemplate();
    static String baseUrl = "http://localhost:8081/questions/v1/";

    private static Object getQuestionsByIdByExchangeMethod(HttpEntity<Object> requestEntity, String questionId) {
        ResponseEntity<Object> responseEntity = restTemplate.exchange(baseUrl + "question/"+questionId ,
                HttpMethod.GET,
                requestEntity,
                Object.class);
        Object questions = responseEntity.getBody();
        //System.out.println(question.size());
//        for(Object a:questions){
//            System.out.println(a);
//        }
        return questions;
    }

    static Object useExchangeMethodsOfRestTemplate(String questionId) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);

        return getQuestionsByIdByExchangeMethod(requestEntity,questionId);

    }
}
