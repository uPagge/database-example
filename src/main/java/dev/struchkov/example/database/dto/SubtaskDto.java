package dev.struchkov.example.database.dto;

import dev.struchkov.example.database.domain.TaskStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubtaskDto {

    private Long id;
    private String name;
    private TaskStatus status;
    private Long epicId;

}
