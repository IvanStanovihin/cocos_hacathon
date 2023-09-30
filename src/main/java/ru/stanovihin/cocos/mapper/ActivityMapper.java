package ru.stanovihin.cocos.mapper;

import org.springframework.stereotype.Service;
import ru.stanovihin.cocos.models.dto.ActivityDto;
import ru.stanovihin.cocos.models.entities.Activity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityMapper {

    public ActivityDto toDto(Activity activity){
        return new ActivityDto()
                .setType(activity.getType())
                .setIntensity(activity.getIntensity())
                .setDate(activity.getDate())
                .setSteps(activity.getSteps())
                .setCalories(activity.getCalories())
                .setImage(activity.getImage())
                .setDuration(activity.getDuration())
                .setAverageSpeed(activity.getAverageSpeed());
    }

    public Activity toEntity(ActivityDto activityDto){
        return new Activity()
                .setType(activityDto.getType())
                .setIntensity(activityDto.getIntensity())
                .setDate(activityDto.getDate())
                .setSteps(activityDto.getSteps())
                .setCalories(activityDto.getCalories())
                .setImage(activityDto.getImage())
                .setDuration(activityDto.getDuration())
                .setAverageSpeed(activityDto.getAverageSpeed());
    }

    public List<ActivityDto> toListEntities(List<Activity> activities){
        return activities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
