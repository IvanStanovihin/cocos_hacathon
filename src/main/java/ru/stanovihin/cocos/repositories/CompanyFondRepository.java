package ru.stanovihin.cocos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.stanovihin.cocos.models.entities.CompanyFond;

@Repository
public interface CompanyFondRepository extends JpaRepository<CompanyFond, Long> {
}
