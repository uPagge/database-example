package dev.struchkov.example.database.controller;

import dev.struchkov.example.database.domain.entity.Epic;
import dev.struchkov.example.database.dto.EpicDto;
import dev.struchkov.example.database.service.EpicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("api/epic")
@RequiredArgsConstructor
@Tag(name = "Управление эпиками")
public class EpicController {

    private final EpicService epicService;
    private final ConversionService conversionService;

    @PostMapping
    @Operation(summary = "Создание нового эпика")
    public ResponseEntity<EpicDto> create(@RequestBody EpicDto epicDto) {
        final Epic newEpic = conversionService.convert(epicDto, Epic.class);
        final Epic saveEpic = epicService.create(newEpic);
        final EpicDto epicVo = conversionService.convert(saveEpic, EpicDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(epicVo);
    }

    @GetMapping("{epicId}")
    @Operation(summary = "Получить эпик по идентификатору")
    public ResponseEntity<EpicDto> getById(@PathVariable(name = "epicId") Long epicId) {
        return ResponseEntity.ok(
                conversionService.convert(epicService.getByIdOrThrow(epicId), EpicDto.class)
        );
    }

    @GetMapping("filter")
    @Operation(summary = "Поиск по имени")
    public ResponseEntity<List<EpicDto>> getAllByEpicName(@RequestParam(name = "name") String name) {
        return ResponseEntity.ok(
                epicService.getLikeName(name).stream()
                        .map(epic -> conversionService.convert(epic, EpicDto.class))
                        .toList()
        );
    }

    @GetMapping
    @Operation(summary = "Пагинация")
    public ResponseEntity<Page<EpicDto>> getAllWithPagination(
            @Parameter(description = "Номер страницы", required = true) @Min(0) @RequestParam Integer pageNum,
            @Parameter(description = "Количество элементов", required = true) @Min(1) @Max(100) @RequestParam Integer pageSize
    ) {
        return ResponseEntity.ok(
                epicService.getByAll(PageRequest.of(pageNum, pageSize))
                        .map(epic -> conversionService.convert(epic, EpicDto.class))
        );
    }

}
