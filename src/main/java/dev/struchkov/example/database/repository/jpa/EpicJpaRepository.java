package dev.struchkov.example.database.repository.jpa;

import dev.struchkov.example.database.domain.entity.Epic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EpicJpaRepository extends JpaRepository<Epic, Long> {

    List<Epic> findAllByNameContainingIgnoreCase(String name);

}
