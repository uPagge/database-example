package dev.struchkov.example.database.repository;

import dev.struchkov.example.database.domain.entity.Epic;
import lombok.NonNull;

import java.util.Optional;

public interface EpicRepository {

    Epic save(@NonNull Epic epic);

    Optional<Epic> findById(@NonNull Long id);

}
