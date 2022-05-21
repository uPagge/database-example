package dev.struchkov.example.database.repository.impl;

import dev.struchkov.example.database.domain.entity.Epic;
import dev.struchkov.example.database.repository.EpicRepository;
import dev.struchkov.example.database.repository.jpa.EpicJpaRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class EpicRepositoryImpl implements EpicRepository {

    private final EpicJpaRepository jpaRepository;

    @Override
    public Epic save(@NonNull Epic epic) {
        return jpaRepository.save(epic);
    }

    @Override
    public Optional<Epic> findById(@NonNull Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<Epic> findAllLikeName(@NonNull String name) {
        return jpaRepository.findAllByNameContainingIgnoreCase(name);
    }

    @Override
    public Page<Epic> findAll(@NonNull Pageable pageable) {
        return jpaRepository.findAll(pageable);
    }

}
