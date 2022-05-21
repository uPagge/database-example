package dev.struchkov.example.database.service.convert;

import dev.struchkov.example.database.domain.entity.Epic;
import dev.struchkov.example.database.dto.EpicDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DtoToEpicConvert implements Converter<EpicDto, Epic> {

    private final DtoToSubtaskConvert dtoToSubtaskConvert;

    @Override
    public Epic convert(EpicDto source) {
        final Epic epic = new Epic();
        epic.setId(source.getId());
        epic.setGoal(source.getGoal());
        epic.setName(source.getName());
        epic.setSubtasks(
                source.getSubtasks().stream()
                        .map(dtoToSubtaskConvert::convert)
                        .toList()
        );
        return epic;
    }

}
