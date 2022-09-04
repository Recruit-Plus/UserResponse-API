package com.recruitPlus.UserResponse.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class UserSubmissions {
    private String questionId;
    private List<String> answer_submitted;
}
