package ru.stanovihin.cocos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.stanovihin.cocos.models.entities.CocosUser;

import java.util.Optional;

@Repository
public interface CocosUserRepository extends CrudRepository<CocosUser, Long> {

    Optional<CocosUser> findByLogin(String login);
}
