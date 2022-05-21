package dev.struchkov.example.database.repository;

import dev.struchkov.example.database.domain.entity.Epic;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EpicRepository {

    Epic save(@NonNull Epic epic);

    Optional<Epic> findById(@NonNull Long id);

    List<Epic> findAllLikeName(@NonNull String name);

    Page<Epic> findAll(@NonNull Pageable pageable);

}
