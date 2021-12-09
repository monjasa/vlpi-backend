package org.monjasa.vlpi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ExerciseAnswerDto {

    private Long id;

    private List<TaskAnswerDto> taskAnswers;

}
