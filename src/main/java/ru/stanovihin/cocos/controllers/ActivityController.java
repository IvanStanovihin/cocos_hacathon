package ru.stanovihin.cocos.controllers;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.stanovihin.cocos.mapper.ActivityMapper;
import ru.stanovihin.cocos.models.dto.ActivityDto;
import ru.stanovihin.cocos.models.entities.Activity;
import ru.stanovihin.cocos.services.ActivityService;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/activity")
public class ActivityController {

    private final ActivityService activityService;
    private final ActivityMapper activityMapper;

    public ActivityController(ActivityService activityService,
                              ActivityMapper activityMapper) {
        this.activityService = activityService;
        this.activityMapper = activityMapper;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> saveActivity(HttpServletRequest request,
            @RequestBody ActivityDto activityDto){
        System.out.println("Received POST /activity");
        activityService.save(request, activityDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(activityService.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/last")
    public ResponseEntity<?> getLast(){
        return ResponseEntity.ok(activityService.findLast(10));
    }
}
