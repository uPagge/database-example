package dev.struchkov.example.database.service.convert;

import dev.struchkov.example.database.domain.entity.Subtask;
import dev.struchkov.example.database.dto.SubtaskDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SubtaskToDtoConvert implements Converter<Subtask, SubtaskDto> {

    @Override
    public SubtaskDto convert(Subtask source) {
        final SubtaskDto subtaskDto = new SubtaskDto();
        subtaskDto.setId(source.getId());
        subtaskDto.setName(source.getName());
        return subtaskDto;
    }

}
