package ru.stanovihin.cocos.services;

import org.springframework.stereotype.Service;
import ru.stanovihin.cocos.mapper.ActivityMapper;
import ru.stanovihin.cocos.models.dto.ActivityDto;
import ru.stanovihin.cocos.models.entities.Activity;
import ru.stanovihin.cocos.models.entities.CocosUser;
import ru.stanovihin.cocos.models.entities.CompanyFond;
import ru.stanovihin.cocos.repositories.ActivityRepository;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final ActivityMapper activityMapper;
    private final CocosUserService cocosUserService;
    private final CoinsService coinsService;
    private final CompanyFondService companyFondService;

    public ActivityService(ActivityRepository activityRepository,
                           ActivityMapper activityMapper,
                           CocosUserService cocosUserService,
                           CoinsService coinsService,
                           CompanyFondService companyFondService) {
        this.activityRepository = activityRepository;
        this.activityMapper = activityMapper;
        this.cocosUserService = cocosUserService;
        this.coinsService = coinsService;
        this.companyFondService = companyFondService;
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

    public void save(HttpServletRequest request,
                     ActivityDto activityDto){
        Activity activity = activityMapper.toEntity(activityDto);
        activity.setCreateDate(LocalDateTime.now().toString());
        int receivedCoins = coinsService.calculateCoins(activityDto);

        //считаем монетки для активити
        activity.setCoinsReceived(receivedCoins + (activityDto.getCoinsReceived() == null ? 0 : activityDto.getCoinsReceived()));
        System.out.println("Found activity: " + activity);

        //считаем монетки для пользователя
        CocosUser cocosUser = cocosUserService.findByRequest(request);
        cocosUser.setCoins(
                (cocosUser.getCoins() == null ? 0 : cocosUser.getCoins()) + activity.getCoinsReceived()
        );
        System.out.println("Found user for activity: " + cocosUser);
        cocosUserService.save(cocosUser);

        //привязываем пользователя в активности
        activity.setCocosUser(cocosUser);

        companyFondService.addCoins(activity.getCoinsReceived());
        activityRepository.save(activity);
    }
}
