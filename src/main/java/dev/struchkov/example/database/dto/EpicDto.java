package dev.struchkov.example.database.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class EpicDto {

    private Long id;
    private String name;
    private String goal;
    private List<SubtaskDto> subtasks = new ArrayList<>();

}
