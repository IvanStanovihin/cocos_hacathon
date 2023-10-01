package ru.stanovihin.cocos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.stanovihin.cocos.models.entities.CocosUser;

import java.util.List;
import java.util.Optional;

@Repository
public interface CocosUserRepository extends CrudRepository<CocosUser, Long> {

    Optional<CocosUser> findByLogin(String login);

    @Query(value = "SELECT * FROM cocos_user ORDER BY coins DESC",
    nativeQuery = true)
    List<CocosUser> findSortedByCoins();
}
