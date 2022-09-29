package com.recruitPlus.UserResponse.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;
import com.recruitPlus.UserResponse.model.UserSubmissions;

@Document(collection = "user_response")
@Data
public class UserResponse {

    @Id
    private String response_id;
    @Field
    private String user_id;
    @Field
    private String assessment_id;
    @Field
    private List<UserSubmissions> responseSubmitted;
    @Field
    private double Time_taken;
    @Field
    private int score;


}
