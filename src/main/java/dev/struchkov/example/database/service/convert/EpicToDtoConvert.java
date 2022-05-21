package dev.struchkov.example.database.service.convert;

import dev.struchkov.example.database.domain.entity.Epic;
import dev.struchkov.example.database.dto.EpicDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EpicToDtoConvert implements Converter<Epic, EpicDto> {

    private final SubtaskToDtoConvert subtaskToDtoConvert;

    @Override
    public EpicDto convert(Epic source) {
        final EpicDto epicDto = new EpicDto();
        epicDto.setId(source.getId());
        epicDto.setSubtasks(
                source.getSubtasks().stream()
                        .map(subtaskToDtoConvert::convert)
                        .toList()
        );
        epicDto.setGoal(source.getGoal());
        return epicDto;
    }

}
