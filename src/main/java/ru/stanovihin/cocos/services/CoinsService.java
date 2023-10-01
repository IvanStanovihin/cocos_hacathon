package ru.stanovihin.cocos.services;

import org.springframework.stereotype.Service;
import ru.stanovihin.cocos.models.dto.ActivityDto;
import ru.stanovihin.cocos.models.entities.Activity;

@Service
public class CoinsService {


    public Integer calculateCoins(ActivityDto activity){
        int tokens = 0;
        switch (activity.getType()) {
            case "run":
                tokens += activity.getDistance() * 0.5; // За каждый километр бега даем 0.5 токена
                tokens += activity.getIntensity() * 2; // За каждый уровень интенсивности даем 2 токена
                tokens += activity.getSteps() / 1000; // За каждые 1000 шагов даем 1 токен
                tokens += activity.getCalories() / 100; // За каждые 100 сожженных калорий даем 1 токен
                tokens += activity.getAverageSpeed() * 0.1; // За каждую километр в средней скорости даем 0.1 токена
                tokens += activity.getDuration() / 60000; // За каждую минуту тренировки даем 1 токен
                break;
            case "bicycle":
                tokens += activity.getDistance() * 0.3; // За каждый километр велосипеда даем 0.3 токена
                tokens += activity.getIntensity() * 1.5; // За каждый уровень интенсивности даем 1.5 токена
                tokens += activity.getCalories()/ 200; // За каждые 200 сожженных калорий даем 1 токен
                tokens += activity.getAverageSpeed() * 0.05; // За каждую километр в средней скорости даем 0.05 токена
                tokens += activity.getDuration() / 60000; // За каждую минуту тренировки даем 1 токен
                break;
            case "swim":
                tokens += activity.getDistance() * 0.7; // За каждый километр плавания даем 0.7 токена
                tokens += activity.getIntensity() * 2.5; // За каждый уровень интенсивности даем 2.5 токена
                tokens += activity.getCalories() / 150; // За каждые 150 сожженных калорий даем 1 токен
                tokens += activity.getDuration()/ 60000; // За каждую минуту тренировки даем 1 токен
                break;
            case "fitness":
                tokens += activity.getIntensity() * 1.2; // За каждый уровень интенсивности даем 1.2 токена
                tokens += activity.getCalories() / 250; // За каждые 250 сожженных калорий даем 1 токен
                tokens += activity.getDuration() / 60000; // За каждую минуту тренировки даем 1 токен
                break;
        }
        return tokens;
    }
}
