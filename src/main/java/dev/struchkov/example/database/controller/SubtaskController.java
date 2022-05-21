package dev.struchkov.example.database.controller;

import dev.struchkov.example.database.domain.entity.Subtask;
import dev.struchkov.example.database.dto.SubtaskDto;
import dev.struchkov.example.database.service.SubtaskService;
import dev.struchkov.example.database.service.TaskManagerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/subtask")
@Tag(name = "Управление подзадачами")
public class SubtaskController {

    private final TaskManagerService taskManager;
    private final SubtaskService subtaskService;
    private final ConversionService conversionService;

    @PostMapping
    @Operation(summary = "Создание новой подзадачи")
    public ResponseEntity<SubtaskDto> create(
            @RequestBody SubtaskDto subtaskDto,
            @RequestParam("epic_id") Long epicId
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        conversionService.convert(
                                taskManager.createSubtask(epicId, conversionService.convert(subtaskDto, Subtask.class)),
                                SubtaskDto.class
                        )
                );
    }

    @PutMapping
    @Operation(summary = "Обновление подзадачи")
    public ResponseEntity<SubtaskDto> update(@RequestBody SubtaskDto subtaskDto) {
        return ResponseEntity.ok(
                conversionService.convert(
                        subtaskService.update(
                                conversionService.convert(subtaskDto, Subtask.class)
                        ),
                        SubtaskDto.class
                )
        );
    }

}
