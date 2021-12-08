package org.monjasa.vlpi.util.mapper;

import org.mapstruct.*;
import org.monjasa.vlpi.domain.ExerciseAnswer;
import org.monjasa.vlpi.domain.TaskAnswer;
import org.monjasa.vlpi.dto.TaskAnswerDto;
import org.monjasa.vlpi.dto.request.TaskAnswerRequest;

@Mapper(componentModel = "spring")
public interface TaskAnswerMapper {

    @Mapping(target = "task.id", source = "taskId")
    TaskAnswer toEntity(TaskAnswerRequest taskAnswerRequest, @Context ExerciseAnswer exerciseAnswer);

    TaskAnswerDto toDto(TaskAnswer taskAnswer);

    @AfterMapping
    default void afterToEntity(@MappingTarget TaskAnswer taskAnswer, @Context ExerciseAnswer exerciseAnswer) {
        taskAnswer.setExerciseAnswer(exerciseAnswer);
    }
}
