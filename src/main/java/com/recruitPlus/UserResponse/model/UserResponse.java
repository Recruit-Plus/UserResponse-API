package com.recruitPlus.UserResponse.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "UserResponse")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class UserResponse {

    @Id
    private String response_id;
    @Field
    private String user_id;
    @Field
    private String assessment_id;
//    @Field
//    List<List<String>> responseSubmitted;
    @Field
    private String questionId;
    @Field
    private List<String> answers_submitted;
    @Field
    private double Time_taken;
    @Field
    private int score;



}
