package dev.struchkov.example.database.repository.jpa;

import dev.struchkov.example.database.domain.entity.Subtask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubtaskJpaRepository extends JpaRepository<Subtask, Long> {

}
