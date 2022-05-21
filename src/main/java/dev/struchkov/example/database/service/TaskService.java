package dev.struchkov.example.database.service;

import dev.struchkov.example.database.repository.jpa.TaskJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskJpaRepository repository;

}
