package dev.struchkov.example.database.service.convert;

import dev.struchkov.example.database.domain.entity.Subtask;
import dev.struchkov.example.database.dto.SubtaskDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DtoToSubtaskConvert implements Converter<SubtaskDto, Subtask> {

    @Override
    public Subtask convert(SubtaskDto source) {
        final Subtask subtask = new Subtask();
        subtask.setId(source.getId());
        subtask.setName(source.getName());
        subtask.setStatus(source.getStatus());
        return subtask;
    }

}
