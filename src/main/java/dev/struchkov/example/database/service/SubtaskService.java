package dev.struchkov.example.database.service;

import dev.struchkov.example.database.domain.entity.Subtask;
import dev.struchkov.example.database.repository.jpa.SubtaskJpaRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubtaskService {

    private final SubtaskJpaRepository repository;

    public Subtask update(@NonNull Subtask subtask) {
        validUpdate(subtask);
        final Subtask oldSubTask = repository.findById(subtask.getId())
                .orElseThrow(RuntimeException::new);
        oldSubTask.setName(subtask.getName());
        return repository.save(oldSubTask);
    }

    private void validUpdate(Subtask subtask) {
        if (subtask.getId() == null) {
            throw new RuntimeException();
        }
    }

    public List<Subtask> getByEpicId(@NonNull Long epicId) {
        return repository.findAllByEpicId(epicId);
    }

}
