package dev.struchkov.example.database.service;

import dev.struchkov.example.database.domain.TaskStatus;
import dev.struchkov.example.database.domain.entity.Epic;
import dev.struchkov.example.database.domain.entity.Subtask;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class TaskManagerService {


    private final EpicService epicService;
    private final SubtaskService subtaskService;
//    private final TaskService taskService;

    @Transactional
    public Subtask createSubtask(@NonNull Long epicId, @NonNull Subtask subtask) {
        final Epic epic = epicService.getById(epicId)
                .orElseThrow(() -> new NotFoundException("Эпик не найден"));
        validCreate(epic, subtask);
        subtask.setStatus(TaskStatus.NEW);
        epic.addSubtask(subtask);
        return subtask;
    }

    private void validCreate(Epic epic, Subtask subtask) {
        if (subtask.getId() != null) {
            throw new RuntimeException();
        }
        if (TaskStatus.CLOSE.equals(epic.getStatus())) {
            throw new RuntimeException();
        }
    }

}
