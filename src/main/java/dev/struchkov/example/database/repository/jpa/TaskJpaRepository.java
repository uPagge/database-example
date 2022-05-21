package dev.struchkov.example.database.repository.jpa;

import dev.struchkov.example.database.domain.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskJpaRepository extends JpaRepository<Task, Long> {

}
