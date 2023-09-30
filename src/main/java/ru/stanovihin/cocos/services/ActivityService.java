package ru.stanovihin.cocos.services;

import org.springframework.stereotype.Service;
import ru.stanovihin.cocos.mapper.ActivityMapper;
import ru.stanovihin.cocos.models.dto.ActivityDto;
import ru.stanovihin.cocos.models.entities.Activity;
import ru.stanovihin.cocos.repositories.ActivityRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final ActivityMapper activityMapper;

    public ActivityService(ActivityRepository activityRepository,
                           ActivityMapper activityMapper) {
        this.activityRepository = activityRepository;
        this.activityMapper = activityMapper;
    }

    public List<ActivityDto> findAll() {
        List<Activity> activities = activityRepository.findAll();
        List<ActivityDto> activityDtos = activityMapper.toListEntities(activities);
        return activityDtos;
    }

    public List<ActivityDto> findLast(Integer countActivities){
        List<Activity> lastActivities = activityRepository.findLast(countActivities);
        List<ActivityDto> activityDtos = activityMapper.toListEntities(lastActivities);
        return activityDtos;
    }

    public void save(ActivityDto activityDto){
        Activity activity = activityMapper.toEntity(activityDto);
        activityRepository.save(activity);
    }
}
