package com.recruitPlus.UserResponse.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="user_feedback")
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
    @Id
    private String user_id;
    @Field
    private String feedback;
}
