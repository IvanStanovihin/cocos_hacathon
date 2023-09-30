package ru.stanovihin.cocos.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class ActivityDto {
    
    //"run" | "swim" | "bicycle" | "fitness"
    private String type;
    
    //км/ч
    private Integer distance;
    // 1 | 2 | 3; // 1 - маленькая, 2 - средняя, 3 - высокая
    private Integer intensity;
    private String date;
    private Integer steps;
    private Integer calories;
    private String image;
    // в минутах
    private Integer duration;
    // км/ч
    private Integer averageSpeed;
}
