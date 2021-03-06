package org.monjasa.vlpi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ExerciseDto {

    private Long id;

    private String name;

    private String description;

    private List<TaskDto> tasks;

}
