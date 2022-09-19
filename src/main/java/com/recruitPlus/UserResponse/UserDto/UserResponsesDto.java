package com.recruitPlus.UserResponse.UserDto;

import lombok.Data;

@Data
public class UserResponsesDto {
    private String user_id;
    private int score;
    private double Time_taken;

    private String user_name;
    private String college_name;
    private String email;
}

