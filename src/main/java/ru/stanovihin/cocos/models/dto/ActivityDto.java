package ru.stanovihin.cocos.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import ru.stanovihin.cocos.models.entities.CocosUser;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class ActivityDto {

    private Long activityId;
    //"run" | "swim" | "bicycle" | "fitness"
    private String type;
    private String createDate;
    
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
    private Integer coinsReceived;
    private CocosUser user;
}
