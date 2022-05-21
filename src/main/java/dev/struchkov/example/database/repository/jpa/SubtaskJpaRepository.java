package dev.struchkov.example.database.repository.jpa;

import dev.struchkov.example.database.domain.entity.Subtask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubtaskJpaRepository extends JpaRepository<Subtask, Long> {

    @Query(nativeQuery = true,
            value = """
                    SELECT *
                    FROM subtask LEFT JOIN epic_subtasks es on subtask.id = es.subtasks_id
                    LEFT JOIN task t on subtask.id = t.id
                    WHERE epic_id = :epicId
                    """)
    List<Subtask> findAllByEpicId(@Param("epicId") Long epicId);

}
