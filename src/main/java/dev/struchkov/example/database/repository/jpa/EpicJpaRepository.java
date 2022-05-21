package dev.struchkov.example.database.repository.jpa;

import dev.struchkov.example.database.domain.entity.Epic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpicJpaRepository extends JpaRepository<Epic, Long> {

}
