package ru.stanovihin.cocos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.stanovihin.cocos.models.dto.ActivityDto;
import ru.stanovihin.cocos.models.entities.Activity;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    @Query(value = "SELECT * FROM activity ORDER BY activity.date DESC LIMIT ?1",
    nativeQuery = true)
    List<Activity> findLast(int i);
}
