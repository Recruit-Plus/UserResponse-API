package com.recruitPlus.UserResponse.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;


public class Question {

    private String question_id;

    private String question;

    private List<String> choices;

    private List<String> answer;

    private String type;

    private List<String> topics;

    private int score;

    private double duration;

    private String created_by;

    private String last_modified_by;

    private String difficulty_level;


}

