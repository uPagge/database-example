package dev.struchkov.example.database.service;

import dev.struchkov.example.database.domain.TaskStatus;
import dev.struchkov.example.database.domain.entity.Epic;
import dev.struchkov.example.database.repository.EpicRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EpicService {

    private final EpicRepository repository;

    public Epic create(@NonNull Epic epic) {
        validNewEpic(epic);
        epic.setStatus(TaskStatus.NEW);
        return repository.save(epic);
    }

    public Optional<Epic> getById(@NonNull Long id) {
        return repository.findById(id);
    }

    public Epic getByIdOrThrow(@NonNull Long id) {
        return getById(id).orElseThrow(() -> new RuntimeException("Эпик не найден"));
    }

    public List<Epic> getLikeName(@NonNull String name) {
        return repository.findAllLikeName(name);
    }

    public Page<Epic> getByAll(@NonNull Pageable pageable) {
        return repository.findAll(pageable);
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
