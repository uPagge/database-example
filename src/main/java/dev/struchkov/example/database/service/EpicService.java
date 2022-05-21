package dev.struchkov.example.database.service;

import dev.struchkov.example.database.domain.TaskStatus;
import dev.struchkov.example.database.domain.entity.Epic;
import dev.struchkov.example.database.repository.EpicRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EpicService {

    private final EpicRepository epicRepository;

    public Epic create(@NonNull Epic epic) {
        validNewEpic(epic);
        epic.setStatus(TaskStatus.NEW);
        return epicRepository.save(epic);
    }

    public Optional<Epic> getById(@NonNull Long id) {
        final Optional<Epic> epic = epicRepository.findById(id);
        return epic;
    }

    private void validNewEpic(Epic epic) {
        if (epic.getId() != null) {
            throw new RuntimeException("Нельзя задавать идентификатор при создании");
        }
        if (!epic.getSubtasks().isEmpty()) {
            throw new RuntimeException("");
        }
    }

}
