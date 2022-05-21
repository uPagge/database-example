package dev.struchkov.example.database.dto;

import dev.struchkov.example.database.domain.TaskStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class EpicDto {

    private Long id;
    private String name;
    private String goal;
    private TaskStatus status;
    private List<SubtaskDto> subtasks = new ArrayList<>();
    private Set<Long> subtaskIds = new HashSet<>();

}
